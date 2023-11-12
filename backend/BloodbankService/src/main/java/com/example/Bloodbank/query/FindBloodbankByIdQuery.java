package com.example.Bloodbank.query;

import lombok.Data;

@Data
public class FindBloodbankByIdQuery {
    private String id;
    public FindBloodbankByIdQuery(String id){
        this.id = id;
    }
}
