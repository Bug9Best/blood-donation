package com.example.AuthService.controller;

import com.example.AuthService.model.LoginRequest;
import com.example.AuthService.model.User;
import com.example.AuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @CrossOrigin
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }


    @RequestMapping(value = "/validatelogin", method = RequestMethod.POST)
    public ResponseEntity<?> validateUser(@RequestBody LoginRequest request) {
        try {
            User user = userService.validate(request.getEmail(), request.getPassword());
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                System.out.println("User not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");  // 404 Not Found
            }
        } catch (Exception e) {
            // Log the exception details
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}

