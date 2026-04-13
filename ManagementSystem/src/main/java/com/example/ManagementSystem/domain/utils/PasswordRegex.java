package com.example.ManagementSystem.domain.utils;

import java.util.ArrayList;
import java.util.List;

public class PasswordRegex {
    public static List<String> validate(String passwd) {
        List<String> errors = new ArrayList<>();

        // Verifica o tamanho: mínimo 8 caracteres
        if (passwd == null || passwd.length() < 8) {
            errors.add("Password length should be 8 or more characters");
        }

        assert passwd != null;
        if (!passwd.matches(".*[0-9].*")) {
            errors.add("Password must have at least one digit");
        }

        if (!passwd.matches(".*[a-zA-Z].*")) {
            errors.add("Password must have at least one letter");
        }

        return errors;
    }
}