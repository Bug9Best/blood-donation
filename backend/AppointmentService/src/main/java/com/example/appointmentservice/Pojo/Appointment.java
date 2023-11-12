package com.example.appointmentservice.pojo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Builder
@Data // Plain Old Java Object
@Document("Appointment") // collection name (Data Model)
public class Appointment implements Serializable {
    @Id
    private String _id;
    private String userid;
    private String appointment;
    private String location;
    private String date;

    public Appointment() {}
    public Appointment(String userid, String appointment, String location,String date) {
        this.userid = userid;
        this.appointment = appointment;
        this.location = location;
        this.date= date;
    }

    public Appointment(String id, String userid, String appointment, String location,String date) {
        this._id = id;
        this.userid = userid;
        this.appointment = appointment;
        this.location = location;
        this.date= date;
    }

}
