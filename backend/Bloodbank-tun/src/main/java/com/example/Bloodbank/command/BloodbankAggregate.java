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
    private String address;
    private String contact_phone;
    private String blood_group;
    private int blood_already;
    private int blood_required;
    public BloodbankAggregate(){}

    @CommandHandler
    public BloodbankAggregate(CreateBloodbankCommand createBloodbankCommand){
        if(createBloodbankCommand.getBlood_group() == null || createBloodbankCommand.getBlood_group().isBlank()){
            throw new IllegalArgumentException("Group cannot be empty");
        }

        if(createBloodbankCommand.getAddress() == null || createBloodbankCommand.getAddress().isBlank()){
            throw new IllegalArgumentException("Address cannot be empty");
        }

        if(createBloodbankCommand.getName() == null || createBloodbankCommand.getName().isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if(createBloodbankCommand.getBlood_required() <= 0){
            throw new IllegalArgumentException("Needed amount cannot be less than or equal to zero");
        }

        if(createBloodbankCommand.getBlood_already() <= 0){
            throw new IllegalArgumentException("Amount cannot be less than or equal to zero");
        }

        if(createBloodbankCommand.getContact_phone() == null || createBloodbankCommand.getContact_phone().isBlank()){
            throw new IllegalArgumentException("Phone number cannot be empty");
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
        this.address = bloodbankCreatedEvent.getAddress();
        this.contact_phone = bloodbankCreatedEvent.getContact_phone();
        this.blood_group = bloodbankCreatedEvent.getBlood_group();
        this.blood_already = bloodbankCreatedEvent.getBlood_already();
        this.blood_required = bloodbankCreatedEvent.getBlood_required();
    }
}
