package com.example.lab66.repository;

import com.example.lab66.pojo.Reward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {
    private final RewardRepository repository;

    @Autowired
    public RewardService(RewardRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value="rewardList")
    public List<Reward> retrieveRewards(){
        return repository.findAll();
    }

    @Cacheable(value="reward", key="#id")
    public Reward retrieveRewardByID(String id) {
        return repository.findByID(id);
    }

    @CachePut(value="reward", key="#reward.getName()")
    @CacheEvict(value="rewardList", allEntries=true)
    public Reward createReward(Reward reward) {
        return repository.save(reward);
    }

    @CachePut(value="reward", key="#reward.getName()")
    @CacheEvict(value="rewardList", allEntries=true)
    public Reward updateReward(Reward reward) {
        return repository.save(reward);
    }

    @CacheEvict(value="reward", key="#reward.getName()")
    @Caching(evict={ @CacheEvict(value="rewardList", allEntries=true) })
    public boolean deleteReward(Reward reward) {
        try {
            repository.delete(reward);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
