package com.example.AuthService.repository;

import com.example.AuthService.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User, String> {

    @Query(value = "{firstname : '?0'}")
    public User findByName(String firstname);

    @Query(value = "{email : '?0'}")
    public User findByEmail(String email);

    @Query(value = "{_id : '?0'}")
    public User findByID(String _id);

}