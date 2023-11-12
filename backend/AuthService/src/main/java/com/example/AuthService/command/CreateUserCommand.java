package com.example.AuthService.command;

import com.example.AuthService.model.User;

public class CreateUserCommand {
    private final User user;

    public CreateUserCommand(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
