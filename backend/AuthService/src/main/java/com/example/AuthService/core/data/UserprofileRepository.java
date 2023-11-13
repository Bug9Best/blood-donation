package com.example.AuthService.core.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserprofileRepository extends MongoRepository<UserEntity, String> {

    UserEntity findBy_id(String _id);

    UserEntity findByEmail(String email);
}
