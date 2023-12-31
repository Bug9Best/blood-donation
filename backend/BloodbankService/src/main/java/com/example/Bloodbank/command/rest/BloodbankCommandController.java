package com.example.Bloodbank.command.rest;

import com.example.Bloodbank.command.CreateBloodbankCommand;
import com.example.Bloodbank.command.UpdateBloodbankCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

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
                .name(model.getName())
                .description(model.getDescription())
                .contact_phone(model.getContact_phone())
                .blood_group_a(model.getBlood_group_a())
                .blood_group_b(model.getBlood_group_b())
                .blood_group_o(model.getBlood_group_o())
                .blood_group_ab(model.getBlood_group_ab())
                .blood_already_a(model.getBlood_already_a())
                .blood_already_b(model.getBlood_already_b())
                .blood_already_o(model.getBlood_already_o())
                .blood_already_ab(model.getBlood_already_ab())
                .blood_required_a(model.getBlood_required_a())
                .blood_required_b(model.getBlood_required_b())
                .blood_required_o(model.getBlood_required_o())
                .blood_required_ab(model.getBlood_required_ab())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch(Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @PutMapping
    public String updateBloodbank(@RequestBody UpdateBloodbankRestModel model) {
        UpdateBloodbankCommand command = UpdateBloodbankCommand.builder()
                ._id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .contact_phone(model.getContact_phone())
                .blood_group_a(model.getBlood_group_a())
                .blood_group_b(model.getBlood_group_b())
                .blood_group_o(model.getBlood_group_o())
                .blood_group_ab(model.getBlood_group_ab())
                .blood_already_a(model.getBlood_already_a())
                .blood_already_b(model.getBlood_already_b())
                .blood_already_o(model.getBlood_already_o())
                .blood_already_ab(model.getBlood_already_ab())
                .blood_required_a(model.getBlood_required_a())
                .blood_required_b(model.getBlood_required_b())
                .blood_required_o(model.getBlood_required_o())
                .blood_required_ab(model.getBlood_required_ab())
                .build();

        String result;
        System.out.println(command);
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
