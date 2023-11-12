package com.example.Bloodbank.query.rest;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BloodbankRestModel {
    @Id // key value (ObjectId for MongoDB)
    private String _id;
    private String name;
    private String address;
    private String contact_phone;
    private String blood_group;
    private int blood_already;
    private int blood_required;
}
