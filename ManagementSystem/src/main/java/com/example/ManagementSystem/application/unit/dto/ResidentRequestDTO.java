package com.example.ManagementSystem.application.unit.dto;

import jakarta.validation.constraints.NotBlank;

public record ResidentRequestDTO(
        @NotBlank(message = "unitIdentification is mandatory")
        String unitIdentification,
        @NotBlank(message = "username must not be empty")
        String username
) {
}
