package com.example.AuthService.query.rest;
import lombok.Data;

@Data
public class SignInRestModel {

    private String email;
    private String password;
}