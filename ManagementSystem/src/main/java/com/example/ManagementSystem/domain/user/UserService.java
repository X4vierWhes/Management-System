package com.example.ManagementSystem.domain.user;

import com.example.ManagementSystem.application.auth.dto.SignInDTO;
import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;


import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAll();

    List<User> getUsersStartsWith(String prefix);

    User getUser(String username);

    User save(SignUpDTO dto);

    Optional<User> signIn(SignInDTO dto);

    User updatePassword(String username, String oldPasswd, String newPasswd);

    int shadowDelete(String username);

    void delete(String username);
}
