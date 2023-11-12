package com.example.Bloodbank.command.rest;

import lombok.Data;

@Data
public class CreateBloodbankRestModel {
    private String name;
    private String address;
    private String contact_phone;
    private String blood_group;
    private int blood_already;
    private int blood_required;
}
