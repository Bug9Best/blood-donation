package com.example.reward.command.rest;

import com.example.reward.command.CreateRewardCommand;
import com.example.reward.command.UpdateRewardCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/rewards")
public class RewardCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
//    private com.example.reward.repository.RewardService rewardService;
    public RewardCommandController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createReward(@RequestBody CreateRewardRestModel model) {
        CreateRewardCommand command = CreateRewardCommand.builder()
                ._id(UUID.randomUUID().toString())
                .image(model.getImage())
                .name(model.getName())
                .point(model.getPoint())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @PutMapping("/{id}")
    public String updateReward(@PathVariable String id, @RequestBody UpdateRewardRestModel model) {
        UpdateRewardCommand command = UpdateRewardCommand.builder()
                ._id(id)
                .image(model.getImage())
                .name(model.getName())
                .point(model.getPoint())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
            if ("update success".equals(result)) {
                return "Update Success";
            } else {
                return "Update failed: " + result;
            }
        } catch (Exception e) {
            result = e.getLocalizedMessage();
            return "Update failed: " + result;
        }
    }
}
