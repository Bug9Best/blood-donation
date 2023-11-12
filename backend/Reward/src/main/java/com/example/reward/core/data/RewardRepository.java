package com.example.reward.core.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RewardRepository extends MongoRepository <RewardEntity, String> {

    Optional<RewardEntity> findBy_id(String _id);
}
