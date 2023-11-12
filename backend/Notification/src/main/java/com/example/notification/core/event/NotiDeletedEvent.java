package com.example.notification.core.event;

import lombok.Data;

@Data
public class NotiDeletedEvent {
    private String _id;
    private String userid;
    private String username;
    private String header;
    private String message;
    private int date;
    private boolean seen;
}
