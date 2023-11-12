package com.example.Bloodbank.command.rest;

import com.example.Bloodbank.command.CreateBloodbankCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/bloodbanks")
public class BloodbankCommandController {
    private final Environment env;

    private final CommandGateway commandGateway;

    @Autowired
    public BloodbankCommandController(Environment env, CommandGateway commandGateway){
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createBloodbank(@RequestBody CreateBloodbankRestModel model){
        CreateBloodbankCommand command = CreateBloodbankCommand.builder()
                ._id(UUID.randomUUID().toString())
                .name(model.getName())
                .address(model.getAddress())
                .contact_phone(model.getContact_phone())
                .blood_group(model.getBlood_group())
                .blood_already(model.getBlood_already())
                .blood_required(model.getBlood_required())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch(Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
