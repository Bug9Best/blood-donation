package com.example.userprofile.query.rest;

import com.example.userprofile.core.data.UserEntity;
import com.example.userprofile.core.data.UserprofileRepository;
import com.example.userprofile.query.FindUserQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserQueryHandler {
    private final UserprofileRepository userprofileRepository;

    public UserQueryHandler(UserprofileRepository userprofileRepository){
        this.userprofileRepository = userprofileRepository;
    }

    @QueryHandler
    public List<UserRestModel> findUser(FindUserQuery query){
        List<UserRestModel> userRest = new ArrayList<>();
        List<UserEntity> storedUser = userprofileRepository.findAll();
        for (UserEntity userEntity : storedUser) {
            UserRestModel userRestModel = new UserRestModel();
            BeanUtils.copyProperties(userEntity, userRestModel);
            userRest.add(userRestModel);
        }
        return userRest;
    }
}
