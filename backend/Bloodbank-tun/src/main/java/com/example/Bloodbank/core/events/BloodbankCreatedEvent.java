package com.example.Bloodbank.core.events;

import lombok.Data;

@Data
public class BloodbankCreatedEvent {
    private String _id;
    private String name;
    private String address;
    private String contact_phone;
    private String blood_group;
    private int blood_already;
    private int blood_required;
}
