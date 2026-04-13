package com.example.ManagementSystem.domain.user;

import com.example.ManagementSystem.application.auth.dto.SignInDTO;
import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.domain.utils.PasswordRegex;
import com.example.ManagementSystem.infrastructure.exception.PasswordNotMatchException;
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
    public List<User> getUsersStartsWith(String prefix) {
        return userRepository.findByUsernamePrefix(prefix);
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

        User user = new User(dto);
        user.setPassword(passwordEncoder.encode(dto.passwd()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> signIn(SignInDTO dto) {
        Optional<User> alreadySaved = userRepository.findByUsernameAndIsActive(dto.username(), true);

        if (alreadySaved.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username or password is incorrect!");

        if (passwordEncoder.matches(dto.password(), alreadySaved.get().getPassword()))
            return alreadySaved;

        return Optional.empty();
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
    public int shadowDelete(String username) {
        return this.userRepository.shadowDelete(username);
    }

    @Override
    public void delete(String username) {
        User user = this.getUser(username);
        this.userRepository.delete(user);
    }
}
