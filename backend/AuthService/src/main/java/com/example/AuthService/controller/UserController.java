package com.example.AuthService.controller;

import com.example.AuthService.model.LoginRequest;
import com.example.AuthService.pojo.User;
import com.example.AuthService.pojo.Users;
import com.example.AuthService.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.retrieveUsers();
        Users listUser = new Users();
        listUser.setModel(users);
        return ResponseEntity.ok(listUser);
        //ResponseEntity return Object and status 200 OK
    }

    @RequestMapping(value ="/user/{_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable("_id") String _id) {
        User user = userService.retrieveUserByID(_id);
        return ResponseEntity.ok(user);
    }


    @RequestMapping(value ="/user/{firstname}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByName(@PathVariable("firstname") String firstname) {
        User user = userService.retrieveUserByName(firstname);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value ="/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @RequestMapping(value ="/updateUser", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User retrieveUser = userService.retrieveUserByID(user.get_id());
        if(retrieveUser != null) {
            User userUpdate = userService.updateUser(retrieveUser);
            return ResponseEntity.ok(userUpdate);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");  // 404 Not Found
        }
    }

    @RequestMapping(value ="/validatelogin", method = RequestMethod.POST)
    public ResponseEntity<?> validateUser(@RequestBody LoginRequest request) {
        User user = userService.validate(request.getEmail(), request.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            System.out.println("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");  // 404 Not Found
        }
    }

    @RequestMapping(value ="/deleteUser/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        User user = userService.retrieveUserByID(id);
        return ResponseEntity.ok(userService.deleteUser(user));
    }
}
