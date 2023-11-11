package com.example.lab66.controller;

import com.example.lab66.pojo.Reward;
import com.example.lab66.repository.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RewardController {
    private final RewardService rewardService;

    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @RequestMapping(value ="/rewards", method = RequestMethod.GET)
    public ResponseEntity<?> getRewards() {
        List<Reward> rewards = rewardService.retrieveRewards();
        return ResponseEntity.ok(rewards);
        //ResponseEntity return Object and status 200 OK
    }

    @RequestMapping(value ="/rewards/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRewardById(@PathVariable("id") String id) {
        Reward reward = rewardService.retrieveRewardByID(id);
        return ResponseEntity.ok(reward);
    }

    @RequestMapping(value ="/addReward/{name}/{point}", method = RequestMethod.POST)
    public ResponseEntity<?> createReward(
            @PathVariable String name,
            @PathVariable int point) {
        Reward reward = rewardService.createReward(new Reward(name, point));
        return ResponseEntity.ok(reward);
    }

    @RequestMapping(value ="/updateReward/{id}/{name}/{point}", method = RequestMethod.POST)
    public ResponseEntity<?> updateReward(
            @PathVariable String id,
            @PathVariable String name,
            @PathVariable int point) {
        Reward reward = rewardService.retrieveRewardByID(id);
        if(reward != null) {
            Reward rewardUpdate = rewardService.updateReward(new Reward(id, name, point));
            return ResponseEntity.ok(rewardUpdate);
        } else {
            return ResponseEntity.ok(null);
        }
    }

    @RequestMapping(value ="/deleteReward/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReward(@PathVariable String id) {
        Reward reward = rewardService.retrieveRewardByID(id);
        return ResponseEntity.ok(rewardService.deleteReward(reward));
    }
}
