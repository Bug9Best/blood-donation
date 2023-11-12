package com.example.Bloodbank.query.rest;

import com.example.Bloodbank.query.FindBloodbankByIdQuery;
import com.example.Bloodbank.query.FindBloodbankQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.springframework.web.bind.annotation.*;
import org.axonframework.queryhandling.QueryGateway;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/bloodbanks")
public class BloodbankQueryController {
    private final QueryGateway queryGateway;

    public BloodbankQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<BloodbankRestModel> getBloodbanks(){
        FindBloodbankQuery findBloodbankQuery = new FindBloodbankQuery();
        return queryGateway.query(findBloodbankQuery, ResponseTypes.multipleInstancesOf(BloodbankRestModel.class)).join();
    }
    @GetMapping("/{id}")
    public BloodbankIdRestModel getBloodbanksById(@PathVariable String id){
        FindBloodbankByIdQuery findBloodbankByIdQuery = new FindBloodbankByIdQuery(id);
        return queryGateway.query(findBloodbankByIdQuery, ResponseTypes.instanceOf(BloodbankIdRestModel.class)).join();
    }
}
