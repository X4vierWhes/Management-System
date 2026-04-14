package com.example.ManagementSystem.application.auth;

import com.example.ManagementSystem.application.auth.dto.SignInDTO;
import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import com.example.ManagementSystem.domain.user.UserService;
import com.example.ManagementSystem.domain.utils.CustomResponseEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthControllerImpl implements AuthController {

    private final UserService userService;

    public AuthControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> signUp(@Valid SignUpDTO createUserDTO) {
        userService.signUp(createUserDTO);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<CustomResponseEntity> signIn(@Valid SignInDTO signInDTO) {
        Optional<UserDTO> userDTO = userService.signIn(signInDTO);

        CustomResponseEntity response = new CustomResponseEntity(userDTO);

        return ResponseEntity.ok(response);
    }
}
