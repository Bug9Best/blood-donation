package com.example.notification.command;

import com.example.notification.core.event.NotiCreatedEvent;
import com.example.notification.core.event.NotiDeletedEvent;
import com.example.notification.core.event.NotiSeenUpdatedEvent;
import com.example.notification.core.event.NotiUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

@Aggregate
public class NotiAggregate {
    @AggregateIdentifier
    private String _id;
    private String userid;
    private String username;
    private String header;
    private String message;
    private int date;
    private boolean seen;

    public NotiAggregate() {

    }

    @CommandHandler
    public NotiAggregate(CreateNotiCommand createNotiCommand) {
        if (createNotiCommand.getUserid() == null || createNotiCommand.getUserid().isBlank()) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
        if (createNotiCommand.getUsername() == null || createNotiCommand.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (createNotiCommand.getHeader() == null || createNotiCommand.getHeader().isBlank()) {
            throw new IllegalArgumentException("Header cannot be empty");
        }
        if (createNotiCommand.getMessage() == null || createNotiCommand.getMessage().isBlank()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }

        NotiCreatedEvent notiCreatedEvent = new NotiCreatedEvent();
        BeanUtils.copyProperties(createNotiCommand, notiCreatedEvent);
        AggregateLifecycle.apply(notiCreatedEvent);
    }

    @CommandHandler
    public String handle(UpdateSeenNotiCommand updateSeenNotiCommand) {

        NotiSeenUpdatedEvent notiSeenUpdatedEvent = new NotiSeenUpdatedEvent();
        BeanUtils.copyProperties(updateSeenNotiCommand, notiSeenUpdatedEvent);
        AggregateLifecycle.apply(notiSeenUpdatedEvent);
        return "Update seen Success";
    }

    @CommandHandler
    public String handler(UpdateNotiCommand updateNotiCommand) {
        if (updateNotiCommand.getUserid() == null || updateNotiCommand.getUserid().isBlank()) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
        if (updateNotiCommand.getUsername() == null || updateNotiCommand.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (updateNotiCommand.getHeader() == null || updateNotiCommand.getHeader().isBlank()) {
            throw new IllegalArgumentException("Header cannot be empty");
        }
        if (updateNotiCommand.getMessage() == null || updateNotiCommand.getMessage().isBlank()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }

        NotiUpdatedEvent notiUpdatedEvent = new NotiUpdatedEvent();
        BeanUtils.copyProperties(updateNotiCommand, notiUpdatedEvent);
        AggregateLifecycle.apply(notiUpdatedEvent);
        return "update success";
    }

    @CommandHandler
    public String handled (DeleteNotiCommand deleteNotiCommand) {

        if (deleteNotiCommand.get_id() == null || deleteNotiCommand.get_id().isBlank()) {
            throw new IllegalArgumentException("Error : Does not exist");
        }

        NotiDeletedEvent notiDeletedEvent = new NotiDeletedEvent();
        BeanUtils.copyProperties(deleteNotiCommand, notiDeletedEvent);
        AggregateLifecycle.apply(notiDeletedEvent);
        return "delete success";
    }




    @EventSourcingHandler
    public void on(NotiCreatedEvent notiCreatedEvent) {
        System.out.println("ON AGGREGATE");
        this._id = notiCreatedEvent.get_id();
        this.userid = notiCreatedEvent.getUserid();
        this.username = notiCreatedEvent.getUsername();
        this.header = notiCreatedEvent.getHeader();
        this.message = notiCreatedEvent.getMessage();
        this.date = notiCreatedEvent.getDate();
        this.seen = notiCreatedEvent.isSeen();
    }

    @EventSourcingHandler
    public void on (NotiSeenUpdatedEvent notiSeenUpdatedEvent) {
        this.userid = notiSeenUpdatedEvent.getUserid();
        this.username = notiSeenUpdatedEvent.getUsername();
        this.header = notiSeenUpdatedEvent.getHeader();
        this.message = notiSeenUpdatedEvent.getMessage();
        this.date = notiSeenUpdatedEvent.getDate();
        this.seen = notiSeenUpdatedEvent.isSeen();
    }

    @EventSourcingHandler
    public void on(NotiUpdatedEvent notiUpdatedEvent) {

        this.userid = notiUpdatedEvent.getUserid();
        this.username = notiUpdatedEvent.getUsername();
        this.header = notiUpdatedEvent.getHeader();
        this.message = notiUpdatedEvent.getMessage();
        this.date = notiUpdatedEvent.getDate();
        this.seen = notiUpdatedEvent.isSeen();

    }

    @EventSourcingHandler
    public void on (NotiDeletedEvent notiDeletedEvent) {
        this.userid = notiDeletedEvent.getUserid();
        this.username = notiDeletedEvent.getUsername();
        this.header = notiDeletedEvent.getHeader();
        this.message = notiDeletedEvent.getMessage();
        this.date = notiDeletedEvent.getDate();
        this.seen = notiDeletedEvent.isSeen();
    }



}
