package com.example.AuthService.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

    // Add getter methods
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
