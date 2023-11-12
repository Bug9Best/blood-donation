package com.example.AuthService.repository;

import com.example.AuthService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmailAndPassword(String email, String password);

}
