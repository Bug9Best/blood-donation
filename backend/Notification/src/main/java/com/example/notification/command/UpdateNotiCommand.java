package com.example.notification.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class UpdateNotiCommand {
    @TargetAggregateIdentifier
    private final String _id;
    private String userid;
    private String username;
    private String header;
    private String message;
    private int date;
    private boolean seen;
}