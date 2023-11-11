package com.example.lab66.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data // Plain Old Java Object
@Document("Reward") // collection name (Data Model)
public class Reward implements Serializable {
    @Id // key value (ObjectId for MongoDB)
    private String _id;
    private String name;
    private int point;

    public Reward() {}
    public Reward(String name, int point) {
        this.name = name;
        this.point = point;
    }
    public Reward(String id, String name, int point) {
        this._id = id;
        this.name = name;
        this.point = point;
    }
}
