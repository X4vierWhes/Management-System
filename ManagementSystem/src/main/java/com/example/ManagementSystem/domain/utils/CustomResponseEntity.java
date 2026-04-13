package com.example.ManagementSystem.domain.utils;

import java.time.LocalDateTime;

public record CustomResponseEntity(Object body, String timestamp) {
    public CustomResponseEntity(Object body) {
        this(body, LocalDateTime.now().toString());
    }
}