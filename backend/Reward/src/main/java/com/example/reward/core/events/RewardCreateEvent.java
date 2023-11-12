package com.example.reward.core.events;

import lombok.Data;

@Data
public class RewardCreateEvent {
    private String _id;
    private String image;
    private String name;
    private int point;
}
