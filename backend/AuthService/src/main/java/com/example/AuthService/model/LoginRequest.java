package com.example.AuthService.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}