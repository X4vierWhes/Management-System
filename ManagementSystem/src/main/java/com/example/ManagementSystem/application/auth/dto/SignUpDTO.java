package com.example.ManagementSystem.application.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignUpDTO(
        @NotBlank(message = "username must not be empty")
        String username,
        @NotBlank(message = "email is mandatory")
        @Email
        String email,
        @NotBlank(message = "password is mandatory")
        String passwd
) {
}