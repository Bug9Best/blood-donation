package com.example.userprofile.core.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("User")
public class UserEntity implements Serializable {
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
