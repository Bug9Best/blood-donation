package com.example.notification.query.rest;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class NotiRestModel {

    @Id //Key value
    private String _id;
    private String userid;
    private String username;
    private String header;
    private String message;
    private int date;
    private boolean seen;


}
