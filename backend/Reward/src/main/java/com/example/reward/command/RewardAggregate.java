package com.example.reward.command;

import com.example.reward.core.events.RewardCreateEvent;
import com.example.reward.core.events.RewardUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class RewardAggregate {
    @AggregateIdentifier
    private String _id;
    private String image;
    private String name;
    private int point;

    public RewardAggregate() {

    }

    @CommandHandler
    public RewardAggregate(CreateRewardCommand createRewardCommand) {
        if (createRewardCommand.getPoint() <= 0) {
            throw new IllegalArgumentException("Point cannot under 0");
        }
        if (createRewardCommand.getName() == null || createRewardCommand.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        RewardCreateEvent rewardCreateEvent = new RewardCreateEvent();
        BeanUtils.copyProperties(createRewardCommand, rewardCreateEvent);
        AggregateLifecycle.apply(rewardCreateEvent);
    }

    @CommandHandler
    public String handle(UpdateRewardCommand updateRewardCommand) {
        if (updateRewardCommand.getPoint() <= 0) {
            throw new IllegalArgumentException("Point cannot be empty");
        }
        if (updateRewardCommand.getName() == null || updateRewardCommand.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (updateRewardCommand.getPoint() <= 0) {
            throw new IllegalArgumentException("Point cannot lower than Zero");
        }
        RewardUpdateEvent rewardUpdatedEvent = new RewardUpdateEvent();
        BeanUtils.copyProperties(updateRewardCommand, rewardUpdatedEvent);
        AggregateLifecycle.apply(rewardUpdatedEvent);
        return "update success";
    }

    @EventSourcingHandler
    public void on(RewardCreateEvent rewardCreateEvent) {
        System.out.println("ON AGGREGATE");
        this._id = rewardCreateEvent.get_id();
        this.image = rewardCreateEvent.getImage();
        this.name = rewardCreateEvent.getName();
        this.point = rewardCreateEvent.getPoint();
    }

    @EventSourcingHandler
    public void on(RewardUpdateEvent rewardUpdatedEvent) {
        this.image = rewardUpdatedEvent.getImage();
        this.name = rewardUpdatedEvent.getName();
        this.point = rewardUpdatedEvent.getPoint();
    }
}
