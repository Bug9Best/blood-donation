package com.example.userprofile.core.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserprofileRepository extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findBy_id(String _id);

    UserEntity findBy_idOrFirstname(String _id,String firstname);
}
