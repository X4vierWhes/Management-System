package com.example.ManagementSystem.application.user.dto;

import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
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
        this(username, email,profile.toUpperCase(), isActive, createdAt.toString());
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getUsername(), user.getEmail(),user.getProfile().name().toUpperCase(), user.getIsActive(), LocalDateTime.now());
    }

    public static UserDTO fromSignUpDTO(SignUpDTO signUpDTO) {
        return new UserDTO(signUpDTO.username(), signUpDTO.email(),signUpDTO.profile().name().toUpperCase(), true, LocalDateTime.now());
    }
}