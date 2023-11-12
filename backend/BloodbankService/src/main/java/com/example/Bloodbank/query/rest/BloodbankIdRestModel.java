package com.example.Bloodbank.query.rest;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BloodbankIdRestModel {
    @Id
    private String _id;
}
