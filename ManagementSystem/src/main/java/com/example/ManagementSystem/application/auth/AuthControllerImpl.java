package com.example.ManagementSystem.application.auth;

import com.example.ManagementSystem.application.auth.dto.SignInDTO;
import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.domain.user.UserService;
import com.example.ManagementSystem.domain.utils.CustomResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class AuthControllerImpl implements AuthController {

    private final UserService userService;

    public AuthControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> signUp(SignUpDTO createUserDTO) {
        return null;
    }

    @Override
    public ResponseEntity<CustomResponseEntity> signIn(SignInDTO signInDTO) {
        return null;
    }
}
