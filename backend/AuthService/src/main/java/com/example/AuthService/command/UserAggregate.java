package com.example.AuthService.command;

import com.example.AuthService.core.event.SignInEvent;
import com.example.AuthService.core.event.UserCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String _id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String bloodGroup;
    private String gender;
    private String dateOfBirth;
    private float weight;
    private float height;
    private String congenitalDisease;
    private String userImage;
    private String role;

    public UserAggregate(){}

    @CommandHandler
    public UserAggregate(CreateUserCommand createUserCommand){
        System.out.println(createUserCommand);
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
        BeanUtils.copyProperties(createUserCommand, userCreatedEvent);
        AggregateLifecycle.apply((userCreatedEvent));
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent userCreatedEvent){
        System.out.println("ON AGGREGATE");
        this._id = userCreatedEvent.get_id();
        this.firstname = userCreatedEvent.getFirstname();
        this.lastname = userCreatedEvent.getLastname();
        this.email = userCreatedEvent.getEmail();
        this.phoneNumber = userCreatedEvent.getPhoneNumber();
        this.bloodGroup = userCreatedEvent.getBloodGroup();
        this.gender = userCreatedEvent.getGender();
        this.dateOfBirth = userCreatedEvent.getDateOfBirth();
        this.weight = userCreatedEvent.getWeight();
        this.height = userCreatedEvent.getHeight();
        this.congenitalDisease = userCreatedEvent.getCongenitalDisease();
        this.userImage = userCreatedEvent.getUserImage();
        this.role = userCreatedEvent.getRole();
    }

}
