package com.example.ManagementSystem.application.user.dto;

import com.example.ManagementSystem.domain.user.User;

import java.time.LocalDateTime;

public record UserDTO(
        String username,
        String email,
        String profile,
        boolean isActive,
        String createdAt
) {

    public UserDTO(String username, String email,String profile,boolean isActive, LocalDateTime createdAt) {
        this(username, email,profile, isActive, createdAt.toString());
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getUsername(), user.getEmail(),user.getProfile().name(), user.getIsActive(), LocalDateTime.now());
    }
}