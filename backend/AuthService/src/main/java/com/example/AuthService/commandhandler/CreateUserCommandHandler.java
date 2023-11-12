package com.example.AuthService.commandhandler;

import com.example.AuthService.command.CreateUserCommand;
import com.example.AuthService.model.User;
import com.example.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler {

    private final UserRepository userRepository;

    @Autowired
    public CreateUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handle(CreateUserCommand command) {
        return userRepository.save(command.getUser());
    }
}
