package com.example.lab66.repository;

import com.example.lab66.pojo.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends MongoRepository <Reward, String> {

    @Query(value = "{name : '?0'}")
    public Reward findByName(String name);

    @Query(value = "{_id : '?0'}")
    public Reward findByID(String id);

}