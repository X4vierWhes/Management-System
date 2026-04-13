package com.example.ManagementSystem.application.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record SignInDTO(
        @NotBlank(message = "username must not be empty")
        String username,
        @NotBlank(message = "password is mandatory")
        String password
) {
}
