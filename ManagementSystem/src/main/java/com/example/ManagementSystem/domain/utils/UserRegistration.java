package com.example.ManagementSystem.domain.utils;

public record UserRegistration(
        String username,
        String email,
        String password,
        String profile,
        boolean isActive
) {}
