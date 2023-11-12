package com.example.Bloodbank.query.rest;

import com.example.Bloodbank.query.FindBloodbankQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.axonframework.queryhandling.QueryGateway;

import javax.management.Query;
import java.util.List;

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
}
