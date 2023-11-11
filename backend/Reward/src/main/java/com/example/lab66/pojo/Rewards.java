package com.example.lab66.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Rewards implements Serializable {
    private List<Reward> model;
}
