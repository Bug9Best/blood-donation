package com.example.AuthService.query.rest;

import com.example.AuthService.query.FindUserQuery;
import com.example.AuthService.query.ValidateUser;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
    @RequestMapping(value = "/auths")
public class UserQueryController {
    private final QueryGateway queryGateway;

    public UserQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<UserRestModel> getUser(){
        FindUserQuery findUserQuery = new FindUserQuery();
        return queryGateway.query(findUserQuery, ResponseTypes.multipleInstancesOf(UserRestModel.class)).join();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInRestModel model) {
        ValidateUser validateUser = new ValidateUser(model.getEmail(), model.getPassword());

        try {
            UserRestModel user = queryGateway.query(validateUser, ResponseTypes.instanceOf(UserRestModel.class)).join();

            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect email or password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request");
        }
    }


}
