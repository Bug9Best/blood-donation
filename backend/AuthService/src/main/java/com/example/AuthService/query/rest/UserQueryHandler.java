package com.example.AuthService.query.rest;

import com.example.AuthService.core.data.UserEntity;
import com.example.AuthService.core.data.UserprofileRepository;
import com.example.AuthService.query.FindUserQuery;
import com.example.AuthService.query.ValidateUser;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @QueryHandler
    public UserRestModel validateUser(ValidateUser query){
        try {
            System.out.println(query);
            UserEntity storedUser = userprofileRepository.findByEmail(query.getEmail());
            System.out.println(storedUser);
            if (Objects.equals(storedUser.getPassword(), query.getPassword())){
                UserRestModel userRestModel = new UserRestModel();
                BeanUtils.copyProperties(storedUser, userRestModel);
                return userRestModel;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

}
