package com.example.Bloodbank.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Bloodbanks implements Serializable {
    private List<Bloodbank> model;
}
