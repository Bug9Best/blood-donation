package com.example.Bloodbank.core.events;

import lombok.Data;

@Data
public class BloodbankCreatedEvent {
    private String _id;
    private String name;
    private String address;
    private String contact_phone;
    private String blood_group_a;
    private String blood_group_b;
    private String blood_group_o;
    private String blood_group_ab;
    private int blood_already_a;
    private int blood_already_b;
    private int blood_already_o;
    private int blood_already_ab;
    private int blood_required_a;
    private int blood_required_b;
    private int blood_required_o;
    private int blood_required_ab;
}
