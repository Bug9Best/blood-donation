package com.je8j.AppointmentService.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data // Plain Old Java Object
@Document("Appointment") // collection name (Data Model)
public class Appointment implements Serializable {
    @Id
    private String _id;
    private String userid;
    private String appointment;
    private String location;

    public Appointment() {}
    public Appointment(String userid, String appointment, String location) {
        this.userid = userid;
        this.appointment = appointment;
        this.location = location;
    }

    public Appointment(String id, String userid, String appointment, String location) {
        this._id = id;
        this.userid = userid;
        this.appointment = appointment;
        this.location = location;
    }

}
