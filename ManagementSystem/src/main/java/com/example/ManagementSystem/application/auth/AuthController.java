package com.example.ManagementSystem.application.auth;

import com.example.ManagementSystem.application.auth.dto.SignInDTO;
import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.domain.utils.CustomResponseEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthController {
    @PostMapping("/signup")
    ResponseEntity<Void> signUp(@RequestBody @Valid SignUpDTO createUserDTO);

    @PostMapping("/signin")
    ResponseEntity<CustomResponseEntity> signIn(@RequestBody @Valid SignInDTO signInDTO);


}
