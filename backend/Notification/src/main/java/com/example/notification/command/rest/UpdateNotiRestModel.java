package com.example.notification.command.rest;

import lombok.Data;

@Data
public class UpdateNotiRestModel {
    private String _id;
    private String userid;
    private String username;
    private String header;
    private String message;
    private int date;
    private boolean seen;
}
