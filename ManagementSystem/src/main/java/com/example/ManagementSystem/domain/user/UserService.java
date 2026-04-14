package com.example.ManagementSystem.domain.user;

import com.example.ManagementSystem.application.auth.dto.SignInDTO;
import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import com.example.ManagementSystem.domain.utils.UserRegistration;


import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAll();

    List<User> getUsersStartsWith(String prefix);

    List<UserDTO> getByIsActive(Boolean isActive);

    User getUser(String username);

    User save(SignUpDTO dto);

    Optional<UserDTO> signIn(SignInDTO dto);

    void signUp(SignUpDTO dto);

    User updatePassword(String username, String oldPasswd, String newPasswd);

    User updateUser(String username, UserDTO dto);

    int shadowDelete(String username);

    void delete(String username);

    User create(UserRegistration data);
}
