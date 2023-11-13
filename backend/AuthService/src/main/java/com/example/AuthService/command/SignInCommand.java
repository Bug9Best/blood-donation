package com.example.AuthService.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class SignInCommand {
    @TargetAggregateIdentifier
    private String email;
    private String password;
}
