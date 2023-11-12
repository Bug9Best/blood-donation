package com.example.AuthService.repository;

import com.example.AuthService.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User validate(String email, String password) {
        User user = repository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public User createUser(User user) {
        return repository.save(user);
    }



}
