package com.example.ManagementSystem.application.auth.dto;

import com.example.ManagementSystem.domain.utils.Profile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SignUpDTO(
        @NotBlank(message = "username must not be empty")
        String username,
        @NotBlank(message = "email is mandatory")
        @Email
        String email,
        @NotBlank(message = "password is mandatory")
        String password,
        @NotNull(message = "O perfil (profile) é obrigatório")
        Profile profile
) {
}