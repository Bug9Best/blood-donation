package com.example.reward.command.rest;

import lombok.Data;

@Data
public class CreateRewardRestModel {
    private String image;
    private String name;
    private int point;
}
