package com.example.Bloodbank.core.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BloodbankRepository extends MongoRepository<BloodbankEntity, String> {
    Optional<BloodbankEntity> findBy_id(String _id);
    BloodbankEntity findBy_idOrName(String _id, String name);

}