package com.example.userprofile.query.rest;

import com.example.userprofile.query.FindUserQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
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
}
