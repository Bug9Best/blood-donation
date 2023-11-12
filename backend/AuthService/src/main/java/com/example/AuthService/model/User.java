package com.example.AuthService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("User")
public class User implements Serializable {
    @Id
    private String _id;
    private String firstname;
    private String lastname;
    private String password;
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

    public User() {}

    public User(String firstname, String lastname,String password,String email, String phoneNumber, String bloodGroup, String gender, String dateOfBirth, float weight, float height, String congenitalDisease, String userImage, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.congenitalDisease = congenitalDisease;
        this.userImage = userImage;
        this.role = role;
    }
    public User(String _id,String firstname,String password, String lastname, String email, String phoneNumber, String bloodGroup, String gender, String dateOfBirth, float weight, float height, String congenitalDisease, String userImage, String role) {
        this._id = _id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.congenitalDisease = congenitalDisease;
        this.userImage = userImage;
        this.role = role;
    }
}
