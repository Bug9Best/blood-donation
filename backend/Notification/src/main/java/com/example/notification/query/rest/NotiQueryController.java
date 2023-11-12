package com.example.notification.query.rest;


import com.example.notification.core.data.NotificationEntity;
import com.example.notification.core.data.NotificationRepository;
import com.example.notification.query.FindNotiByIdQuery;
import com.example.notification.query.FindNotiByUserIdQuery;
import com.example.notification.query.FindNotiQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping(value = "/notifications")
public class NotiQueryController {
    private final QueryGateway queryGateway;

    public NotiQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<NotiRestModel> getNoti() {
        FindNotiQuery findNotiQuery = new FindNotiQuery();
        return queryGateway.query(findNotiQuery, ResponseTypes.multipleInstancesOf(NotiRestModel.class)).join();
    }

    @GetMapping("/{id}")
    public NotiRestModel getNotiById(@PathVariable String id) {
        FindNotiByIdQuery findNotiByIdQuery = new FindNotiByIdQuery(id);
        return queryGateway.query(findNotiByIdQuery, ResponseTypes.instanceOf(NotiRestModel.class)).join();
    }

    @GetMapping("/user/{userid}")
    public List<NotiRestModel> getNotiByUserId(@PathVariable String userid) {
        FindNotiByUserIdQuery findNotiByUserIdQuery = new FindNotiByUserIdQuery(userid);
        return queryGateway.query(findNotiByUserIdQuery, ResponseTypes.multipleInstancesOf(NotiRestModel.class)).join();
    }



}
