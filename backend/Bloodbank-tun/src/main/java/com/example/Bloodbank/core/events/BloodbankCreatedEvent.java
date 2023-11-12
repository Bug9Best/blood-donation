package com.example.Bloodbank.core.events;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BloodbankCreatedEvent {
    @Id
    private String _id;
    private String name;
    private int amount;
}
