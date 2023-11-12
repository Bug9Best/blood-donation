package com.example.reward.query.rest;

import com.example.reward.query.FindRewardByIdQuery;
import com.example.reward.query.FindRewardQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/rewards")
public class RewardQueryController {
    private final QueryGateway queryGateway;

    public RewardQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<RewardRestModel> getRewards(){
        FindRewardQuery findRewardQuery = new FindRewardQuery();
        return queryGateway.query(findRewardQuery, ResponseTypes.multipleInstancesOf(RewardRestModel.class)).join();
    }

    @GetMapping("/{id}")
    public RewardRestModel getRewardById(@PathVariable String id){
        FindRewardByIdQuery findRewardByIdQuery = new FindRewardByIdQuery(id);
        return queryGateway.query(findRewardByIdQuery, ResponseTypes.instanceOf(RewardRestModel.class)).join();
    }
}
