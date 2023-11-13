package com.example.AuthService.core.event;

import lombok.Data;

@Data
public class SignInEvent {

    private String email;
    private String password;
    // Additional user details

}
