package com.example.reward.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateRewardCommand {
    @TargetAggregateIdentifier
    private final String _id;
    private String image;
    private String name;
    private int point;
}
