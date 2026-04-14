package com.example.ManagementSystem.domain.user;

import com.example.ManagementSystem.application.auth.dto.SignInDTO;
import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import com.example.ManagementSystem.domain.utils.PasswordRegex;
import com.example.ManagementSystem.domain.utils.Profile;
import com.example.ManagementSystem.domain.utils.UserRegistration;
import com.example.ManagementSystem.infrastructure.exception.PasswordNotMatchException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(User::toDTO).toList();
    }

    @Override
    public List<User> getUsersStartsWith(String prefix) {
        return userRepository.findByUsernamePrefix(prefix);
    }

    @Override
    public List<UserDTO> getByIsActive(Boolean isActive) {
        return userRepository.findAllByIsActive(isActive).stream().map(User::toDTO).toList();
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsernameAndIsActive(username, true).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NO_CONTENT)
        );
    }

    @Override
    public User save(SignUpDTO dto) {
        List<User> alreadySaved = userRepository.findByUsernameOrEmailAndIsActive(dto.username(), dto.email());

        if (!alreadySaved.isEmpty())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The username is taken!");

        User user = new User();
        user.updateUser(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Optional<UserDTO> signIn(SignInDTO dto) {
        User user = userRepository.findByUsernameAndIsActive(dto.username(), true)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username ou senha incorretos"));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username ou senha incorretos");
        }

        return Optional.ofNullable(user.toDTO());
    }

    @Override
    public void signUp(SignUpDTO dto) {
            List<User> alreadySaved = userRepository.findByUsernameOrEmailAndIsActive(dto.username(), dto.email());

            if (!alreadySaved.isEmpty())
                throw new ResponseStatusException(HttpStatus.CONFLICT, "The username is taken!");

            User user = new User();
            user.updateUser(dto);
            user.setPassword(passwordEncoder.encode(dto.password()));
            user.setProfile(Profile.valueOf(String.valueOf(dto.profile())));
            user.setCreatedAt(java.time.LocalDateTime.now());
            userRepository.save(user);
    }

    private String hashPassword(String raw) {
        List<String> errors = PasswordRegex.validate(raw);

        if (!errors.isEmpty())
            throw new PasswordNotMatchException(errors);

        return this.passwordEncoder.encode(raw);
    }

    @Override
    public User updatePassword(String username, String oldPasswd, String newPasswd) {
        List<String> reasons = PasswordRegex.validate(newPasswd);

        if (!reasons.isEmpty())
            throw new PasswordNotMatchException(reasons);

        User user = this.getUser(username);
        String hashedPassword = hashPassword(newPasswd);
        if (this.passwordEncoder.matches(hashedPassword, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The old password is wrong!");

        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String username, UserDTO dto) {
        User user = this.getUser(username);

        if(dto.email() == null ||dto.email().isBlank() )
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email cannot be empty!");

        if(dto.username() == null ||dto.username().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username cannot be empty!");

        if(dto.profile()  == null || dto.profile().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Profile cannot be empty!");

        user.setEmail(dto.email());
        user.setUsername(dto.username());
        user.setProfile(Profile.valueOf(dto.profile().toUpperCase()));
        user.setIsActive(dto.isActive());

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public int shadowDelete(String username) {
        return this.userRepository.shadowDelete(username);
    }

    @Override
    @Transactional
    public void delete(String username) {
        User user = this.getUser(username);
        this.userRepository.delete(user);
    }

    @Override
    public User create(UserRegistration data) {
        if (this.userRepository.findByEmailAndIsActive(data.email(), true).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado!");
        }

        if (this.userRepository.findByUsernameAndIsActive(data.username(), true).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username já cadastrado!");
        }

        User newUser = new User();
        newUser.setUsername(data.username());
        newUser.setEmail(data.email());
        newUser.setPassword(this.passwordEncoder.encode(data.password()));
        newUser.setProfile(Profile.valueOf(data.profile().toUpperCase()));
        newUser.setIsActive(data.isActive());
        newUser.setCreatedAt(java.time.LocalDateTime.now());

        return userRepository.save(newUser);
    }
}
