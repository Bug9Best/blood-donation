package com.example.Bloodbank.command;

import com.example.Bloodbank.core.events.BloodbankCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class BloodbankAggregate {
    @AggregateIdentifier
    private String _id;
    private String name;
    private int amount;
    public BloodbankAggregate(){}

    @CommandHandler
    public BloodbankAggregate(CreateBloodbankCommand createBloodbankCommand){
        if(createBloodbankCommand.getName() == null || createBloodbankCommand.getName().isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if(createBloodbankCommand.getAmount() <= 0){
            throw new IllegalArgumentException("Amount cannot be less than or equal to zero");
        }

        BloodbankCreatedEvent bloodbankCreatedEvent = new BloodbankCreatedEvent();
        BeanUtils.copyProperties(createBloodbankCommand, bloodbankCreatedEvent);
        AggregateLifecycle.apply((bloodbankCreatedEvent));

    }

    @EventSourcingHandler
    public void on(BloodbankCreatedEvent bloodbankCreatedEvent){
        System.out.println("ON AGGREGATE");
        this._id = bloodbankCreatedEvent.get_id();
        this.name = bloodbankCreatedEvent.getName();
        this.amount = bloodbankCreatedEvent.getAmount();
    }
}
