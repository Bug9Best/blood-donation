package com.example.reward.query;

public class FindRewardByIdQuery {
    private final String rewardId;

    public FindRewardByIdQuery(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardId() {
        return rewardId;
    }
}
