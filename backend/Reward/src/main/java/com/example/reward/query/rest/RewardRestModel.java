package com.example.reward.query.rest;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class RewardRestModel {
    @Id
    private String _id;
    private String image;
    private String name;
    private int point;
}
