package com.example.userprofile.query.rest;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserRestModel {
    @Id
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
