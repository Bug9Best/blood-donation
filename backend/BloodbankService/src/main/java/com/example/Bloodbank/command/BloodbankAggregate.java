package com.example.Bloodbank.command;

import com.example.Bloodbank.core.events.BloodbankCreatedEvent;
import com.example.Bloodbank.core.events.BloodbankUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class BloodbankAggregate {
    private String _id;
    @AggregateIdentifier

    private String name;
    private String description;
    private String contact_phone;
    private String blood_group_a;
    private String blood_group_b;
    private String blood_group_o;
    private String blood_group_ab;
    private int blood_already_a;
    private int blood_already_b;
    private int blood_already_o;
    private int blood_already_ab;
    private int blood_required_a;
    private int blood_required_b;
    private int blood_required_o;
    private int blood_required_ab;
    public BloodbankAggregate(){}

    @CommandHandler
    public BloodbankAggregate(CreateBloodbankCommand createBloodbankCommand) {
        BloodbankCreatedEvent bloodbankCreatedEvent = new BloodbankCreatedEvent();
        BeanUtils.copyProperties(createBloodbankCommand, bloodbankCreatedEvent);
        AggregateLifecycle.apply(bloodbankCreatedEvent);
    }

    @CommandHandler
    public BloodbankAggregate(UpdateBloodbankCommand updateBloodbankCommand) {
        BloodbankUpdatedEvent bloodbankUpdatedEvent = new BloodbankUpdatedEvent();
        BeanUtils.copyProperties(updateBloodbankCommand, bloodbankUpdatedEvent);
        AggregateLifecycle.apply(bloodbankUpdatedEvent);
    }

    @EventSourcingHandler
    public void onBloodbankCreated(BloodbankCreatedEvent bloodbankCreatedEvent){
        System.out.println("ON CREATE AGGREGATE");
        this._id = bloodbankCreatedEvent.get_id();
        this.name = bloodbankCreatedEvent.getName();
        this.description = bloodbankCreatedEvent.getDescription();
        this.contact_phone = bloodbankCreatedEvent.getContact_phone();
        this.blood_group_a = bloodbankCreatedEvent.getBlood_group_a();
        this.blood_group_b = bloodbankCreatedEvent.getBlood_group_b();
        this.blood_group_o = bloodbankCreatedEvent.getBlood_group_o();
        this.blood_group_ab = bloodbankCreatedEvent.getBlood_group_ab();
        this.blood_already_a = bloodbankCreatedEvent.getBlood_already_a();
        this.blood_already_b = bloodbankCreatedEvent.getBlood_already_b();
        this.blood_already_o = bloodbankCreatedEvent.getBlood_already_o();
        this.blood_already_ab = bloodbankCreatedEvent.getBlood_already_ab();
        this.blood_required_a = bloodbankCreatedEvent.getBlood_required_a();
        this.blood_required_b = bloodbankCreatedEvent.getBlood_required_b();
        this.blood_required_o = bloodbankCreatedEvent.getBlood_required_o();
        this.blood_required_ab = bloodbankCreatedEvent.getBlood_required_ab();
    }

    @EventSourcingHandler
    public void onBloodbankUpdated(BloodbankUpdatedEvent bloodbankUpdatedEvent){
        System.out.println("ON AGGREGATE");
        this._id = bloodbankUpdatedEvent.get_id();
        this.name = bloodbankUpdatedEvent.getName();
        this.description = bloodbankUpdatedEvent.getDescription();
        this.contact_phone = bloodbankUpdatedEvent.getContact_phone();
        this.blood_group_a = bloodbankUpdatedEvent.getBlood_group_a();
        this.blood_group_b = bloodbankUpdatedEvent.getBlood_group_b();
        this.blood_group_o = bloodbankUpdatedEvent.getBlood_group_o();
        this.blood_group_ab = bloodbankUpdatedEvent.getBlood_group_ab();
        this.blood_already_a = bloodbankUpdatedEvent.getBlood_already_a();
        this.blood_already_b = bloodbankUpdatedEvent.getBlood_already_b();
        this.blood_already_o = bloodbankUpdatedEvent.getBlood_already_o();
        this.blood_already_ab = bloodbankUpdatedEvent.getBlood_already_ab();
        this.blood_required_a = bloodbankUpdatedEvent.getBlood_required_a();
        this.blood_required_b = bloodbankUpdatedEvent.getBlood_required_b();
        this.blood_required_o = bloodbankUpdatedEvent.getBlood_required_o();
        this.blood_required_ab = bloodbankUpdatedEvent.getBlood_required_ab();
    }

}
