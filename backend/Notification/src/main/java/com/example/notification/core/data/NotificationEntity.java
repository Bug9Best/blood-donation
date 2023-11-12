package com.example.notification.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Data
@Table (name = "Notification")
public class NotificationEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -4483799524881450723L;
    @Id
    @Column(unique = true)
    private String _id;

    private String userid;
    private String username;
    private String header;
    private String message;
    private int date;
    private boolean seen;

//    public NotificationEntity(){
//
//    }

//    public NotificationEntity(String _id, String userid, String username, String header, String message, int date, boolean seen) {
//        this._id = _id;
//        this.userid = userid;
//        this.username = username;
//        this.header = header;
//        this.message = message;
//        this.date = date;
//        this.seen = seen;
//
//    }
}
