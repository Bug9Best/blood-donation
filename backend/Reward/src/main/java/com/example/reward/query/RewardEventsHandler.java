package com.example.reward.query;

import com.example.reward.core.data.RewardEntity;
import com.example.reward.core.data.RewardRepository;
import com.example.reward.core.events.RewardCreateEvent;
import com.example.reward.core.events.RewardUpdateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RewardEventsHandler {
    private final RewardRepository rewardRepository;

    public RewardEventsHandler(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @EventHandler
    public void on(RewardCreateEvent event) {
        RewardEntity rewardEntity = new RewardEntity();
        BeanUtils.copyProperties(event, rewardEntity);
        rewardRepository.save(rewardEntity);
    }

    @EventHandler
    public void on(RewardUpdateEvent event) {
        RewardEntity rewardEntity = rewardRepository.findBy_id(event.get_id())
                .orElseThrow(() -> new RuntimeException("Not found reward"));
        rewardEntity.setImage(event.getImage());
        rewardEntity.setName(event.getName());
        rewardEntity.setPoint(event.getPoint());
        rewardRepository.save(rewardEntity);
    }
}
