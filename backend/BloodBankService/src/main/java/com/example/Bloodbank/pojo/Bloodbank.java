package com.example.Bloodbank.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data // Plain Old Java Object
@Document("Bloodbank") // collection name (Data Model)
public class Bloodbank implements Serializable {
    @Id // key value (ObjectId for MongoDB)
    private String _id;
    private String name;
    private int amount;

    public Bloodbank() {}
    public Bloodbank(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
    public Bloodbank(String id, String name, int amount) {
        this._id = id;
        this.name = name;
        this.amount = amount;
    }
}
