package com.example.ManagementSystem.application.user.dto;

import com.example.ManagementSystem.domain.user.User;

import java.time.LocalDateTime;

public record UserDTO(
        String username,
        String email,
        String createdAt
) {

    public UserDTO(String username, String email, LocalDateTime createdAt) {
        this(username, email, createdAt.toString());
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getUsername(), user.getEmail(), LocalDateTime.now());
    }
}