package com.example.Bloodbank.query.rest;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BloodbankRestModel {
    @Id // key value (ObjectId for MongoDB)
    private String _id;
    private String name;
    private int amount;
}
