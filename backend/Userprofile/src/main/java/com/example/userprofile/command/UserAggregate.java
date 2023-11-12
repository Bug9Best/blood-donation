package com.example.userprofile.command;

import com.example.userprofile.core.event.UserCreatedEvent;
import com.example.userprofile.core.event.UserUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserAggregate {
    private String _id;
    @AggregateIdentifier

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
//        if(createUserCommand.getFirstname() == null || createUserCommand.getFirstname().isBlank()){
//            throw new IllegalArgumentException("Firstname cannot be empty");
//        }
//
//        if(createUserCommand.getLastname() == null || createUserCommand.getLastname().isBlank()){
//            throw new IllegalArgumentException("Lastname cannot be empty");
//        }
//        if(createUserCommand.getEmail() == null || createUserCommand.getEmail().isBlank()){
//            throw new IllegalArgumentException("Email cannot be empty");
//        }
//        if(createUserCommand.getPhoneNumber() == null || createUserCommand.getPhoneNumber().isBlank()){
//            throw new IllegalArgumentException("Phonenumber cannot be empty");
//        }
//        if(createUserCommand.getBloodGroup() == null || createUserCommand.getBloodGroup().isBlank()){
//            throw new IllegalArgumentException("Bloodgroup cannot be empty");
//        }
//        if(createUserCommand.getGender() == null || createUserCommand.getGender().isBlank()){
//            throw new IllegalArgumentException("Gender cannot be empty");
//        }
//        if(createUserCommand.getDateOfBirth() == null || createUserCommand.getDateOfBirth().isBlank()){
//            throw new IllegalArgumentException("DateofBirth cannot be empty");
//        }
//        if(createUserCommand.getWeight() == 0 ){
//            throw new IllegalArgumentException("Weight cannot be empty");
//        }
//        if(createUserCommand.getHeight() == 0 ){
//            throw new IllegalArgumentException("Height cannot be empty");
//        }
//        if(createUserCommand.getCongenitalDisease() == null || createUserCommand.getCongenitalDisease().isBlank()){
//            throw new IllegalArgumentException("Congenital disease cannot be empty");
//        }
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
        BeanUtils.copyProperties(createUserCommand, userCreatedEvent);
        AggregateLifecycle.apply((userCreatedEvent));
    }

    @CommandHandler
    public UserAggregate(UpdateUserCommand updateUserCommand){
//        if(updateUserCommand.getFirstname() == null || updateUserCommand.getFirstname().isBlank()){
//            throw new IllegalArgumentException("Firstname cannot be empty");
//        }
//
//        if(updateUserCommand.getLastname() == null || updateUserCommand.getLastname().isBlank()){
//            throw new IllegalArgumentException("Lastname cannot be empty");
//        }
//        if(updateUserCommand.getEmail() == null || updateUserCommand.getEmail().isBlank()){
//            throw new IllegalArgumentException("Email cannot be empty");
//        }
//        if(updateUserCommand.getPhoneNumber() == null || updateUserCommand.getPhoneNumber().isBlank()){
//            throw new IllegalArgumentException("Phonenumber cannot be empty");
//        }
//        if(updateUserCommand.getBloodGroup() == null || updateUserCommand.getBloodGroup().isBlank()){
//            throw new IllegalArgumentException("Bloodgroup cannot be empty");
//        }
//        if(updateUserCommand.getGender() == null || updateUserCommand.getGender().isBlank()){
//            throw new IllegalArgumentException("Gender cannot be empty");
//        }
//        if(updateUserCommand.getDateOfBirth() == null || updateUserCommand.getDateOfBirth().isBlank()){
//            throw new IllegalArgumentException("DateofBirth cannot be empty");
//        }
//        if(updateUserCommand.getWeight() == 0 ){
//            throw new IllegalArgumentException("Weight cannot be empty");
//        }
//        if(updateUserCommand.getHeight() == 0 ){
//            throw new IllegalArgumentException("Height cannot be empty");
//        }
//        if(updateUserCommand.getCongenitalDisease() == null || updateUserCommand.getCongenitalDisease().isBlank()){
//            throw new IllegalArgumentException("Congenital disease cannot be empty");
//        }
        UserUpdatedEvent userUpdatedEvent = new UserUpdatedEvent();
        BeanUtils.copyProperties(updateUserCommand, userUpdatedEvent);
        AggregateLifecycle.apply((userUpdatedEvent));
    }
    @EventSourcingHandler
    public void onUserCreated(UserCreatedEvent userCreatedEvent){
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

    @EventSourcingHandler
    public void onUserUpdated(UserUpdatedEvent userUpdatedEvent){
        System.out.println("ON AGGREGATE");
        this._id = userUpdatedEvent.get_id();
        this.firstname = userUpdatedEvent.getFirstname();
        this.lastname = userUpdatedEvent.getLastname();
        this.email = userUpdatedEvent.getEmail();
        this.phoneNumber = userUpdatedEvent.getPhoneNumber();
        this.bloodGroup = userUpdatedEvent.getBloodGroup();
        this.gender = userUpdatedEvent.getGender();
        this.dateOfBirth = userUpdatedEvent.getDateOfBirth();
        this.weight = userUpdatedEvent.getWeight();
        this.height = userUpdatedEvent.getHeight();
        this.congenitalDisease = userUpdatedEvent.getCongenitalDisease();
        this.userImage = userUpdatedEvent.getUserImage();
        this.role = userUpdatedEvent.getRole();
    }
}
