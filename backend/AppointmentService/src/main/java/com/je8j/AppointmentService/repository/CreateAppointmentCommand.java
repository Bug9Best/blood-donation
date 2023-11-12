package com.je8j.AppointmentService.repository;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateAppointmentCommand {
    @TargetAggregateIdentifier
    private String _id;
    private String userid;
    private String appointment;
    private String location;
}
