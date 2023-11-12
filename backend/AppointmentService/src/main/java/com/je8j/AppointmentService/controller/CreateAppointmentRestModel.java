package com.je8j.AppointmentService.controller;

import lombok.Data;

@Data

public class CreateAppointmentRestModel {
    private String _id;
    private String userid;
    private String appointment;
    private String location;
}
