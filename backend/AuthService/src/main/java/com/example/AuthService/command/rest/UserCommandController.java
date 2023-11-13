package com.example.AuthService.command.rest;

import com.example.AuthService.command.CreateUserCommand;
import com.example.AuthService.command.SignInCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/auths")
public class UserCommandController {
    private final Environment env;

    private final CommandGateway commandGateway;

    @Autowired
    public UserCommandController(Environment env,CommandGateway commandGateway){
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping("/create-user")
    public String createUser(@RequestBody CreateUserRestModel model) {
        CreateUserCommand command = CreateUserCommand.builder()
                ._id(UUID.randomUUID().toString())
                .firstname(model.getFirstname())
                .lastname(model.getLastname())
                .email(model.getEmail())
                .password(model.getPassword())
                .phoneNumber(model.getPhoneNumber())
                .bloodGroup(model.getBloodGroup())
                .gender(model.getGender())
                .dateOfBirth(model.getDateOfBirth())
                .weight(model.getWeight())
                .height(model.getHeight())
                .congenitalDisease(model.getCongenitalDisease())
                .userImage(model.getUserImage())
                .role(model.getRole())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }


}
