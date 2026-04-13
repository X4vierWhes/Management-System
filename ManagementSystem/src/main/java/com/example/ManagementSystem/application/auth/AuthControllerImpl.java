package com.example.ManagementSystem.application.auth;

import com.example.ManagementSystem.application.auth.dto.SignInDTO;
import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.domain.user.UserService;
import com.example.ManagementSystem.domain.utils.CustomResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AuthControllerImpl implements AuthController {

    private final UserService userService;

    public AuthControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> signUp(SignUpDTO createUserDTO) {
        userService.signUp(createUserDTO);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<CustomResponseEntity> signIn(SignInDTO signInDTO) {
        userService.signIn(signInDTO);
        return ResponseEntity.status(200).build();
    }
}
