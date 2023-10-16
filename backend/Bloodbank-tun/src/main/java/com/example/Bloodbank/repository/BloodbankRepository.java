package com.example.Bloodbank.repository;

import com.example.Bloodbank.pojo.Bloodbank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodbankRepository extends MongoRepository <Bloodbank, String> {

    @Query(value = "{name : '?0'}")
    public Bloodbank findByName(String name);

    @Query(value = "{_id : '?0'}")
    public Bloodbank findByID(String id);

}