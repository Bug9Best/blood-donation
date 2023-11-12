package com.example.Bloodbank.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateBloodbankCommand {
    @TargetAggregateIdentifier
    private final String _id;
    private String name;
    private String address;
    private String contact_phone;
    private String blood_group;
    private int blood_already;
    private int blood_required;
}
