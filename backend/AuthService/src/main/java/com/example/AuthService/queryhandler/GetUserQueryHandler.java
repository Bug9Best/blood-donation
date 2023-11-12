package com.example.AuthService.queryhandler;

import com.example.AuthService.model.User;
import com.example.AuthService.query.GetUserQuery;
import com.example.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserQueryHandler {
    private final UserRepository userRepository;

    @Autowired
    public GetUserQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handle(GetUserQuery query) {
        Optional<User> userOptional = userRepository.findByEmailAndPassword(query.getEmail(), query.getPassword());
        return userOptional.orElse(null);
    }
}
