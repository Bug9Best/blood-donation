package com.example.AuthService.service;

import com.example.AuthService.model.User;
import com.example.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AuthService.command.CreateUserCommand;
import java.util.Optional;

import com.example.AuthService.commandhandler.CreateUserCommandHandler;

@Service
public class UserService {

    private final UserRepository repository;
    private final CreateUserCommandHandler createUserCommandHandler;

    @Autowired
    public UserService(UserRepository repository, CreateUserCommandHandler createUserCommandHandler) {
        this.repository = repository;
        this.createUserCommandHandler = createUserCommandHandler;
    }

    public User validate(String email, String password) {
        Optional<User> userOptional = repository.findByEmailAndPassword(email, password);
        return userOptional.orElse(null);
    }

    public User createUser(User user) {
        CreateUserCommand createUserCommand = new CreateUserCommand(user);
        return createUserCommandHandler.handle(createUserCommand);
    }
}
