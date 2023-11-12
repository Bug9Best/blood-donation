package com.example.reward.query.rest;

import com.example.reward.core.data.RewardEntity;
import com.example.reward.core.data.RewardRepository;
import com.example.reward.query.FindRewardByIdQuery;
import com.example.reward.query.FindRewardQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RewardQueryHandler {
    private final RewardRepository rewardRepository;

    public RewardQueryHandler(RewardRepository rewardRepository){
        this.rewardRepository = rewardRepository;
    }

    @QueryHandler
    public List<RewardRestModel> findReward(FindRewardQuery query){
        List<RewardRestModel> rewardRest = new ArrayList<>();
        List<RewardEntity> storedReward = rewardRepository.findAll();
        for (RewardEntity rewardEntity : storedReward) {
            RewardRestModel rewardRestModel = new RewardRestModel();
            BeanUtils.copyProperties(rewardEntity, rewardRestModel);
            rewardRest.add(rewardRestModel);
        }
        return rewardRest;
    }

    @QueryHandler
    public RewardRestModel findRewardById(FindRewardByIdQuery query){
        RewardEntity rewardEntity = rewardRepository.findBy_id(query.getRewardId())
                .orElseThrow(() -> new RuntimeException("Reward not found with id: " + query.getRewardId()));

        RewardRestModel rewardRestModel = new RewardRestModel();
        BeanUtils.copyProperties(rewardEntity, rewardRestModel);

        return rewardRestModel;
    }
}
