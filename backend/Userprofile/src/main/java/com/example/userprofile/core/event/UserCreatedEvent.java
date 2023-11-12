package com.example.userprofile.core.event;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserCreatedEvent {
    private String _id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String bloodGroup;
    private String gender;
    private String dateOfBirth;
    private float weight;
    private float height;
    private String congenitalDisease;
    private String userImage;
    private String role;

}
