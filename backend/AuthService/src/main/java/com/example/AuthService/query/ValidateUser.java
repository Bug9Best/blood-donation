package com.example.AuthService.query;

import lombok.Data;

@Data
public class ValidateUser {
    private String email;
    private String password;

    public ValidateUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
