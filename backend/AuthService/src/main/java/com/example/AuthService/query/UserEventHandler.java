package com.example.AuthService.query;

import com.example.AuthService.core.data.UserEntity;
import com.example.AuthService.core.data.UserprofileRepository;
import com.example.AuthService.core.event.SignInEvent;
import com.example.AuthService.core.event.UserCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {
    private final UserprofileRepository userprofileRepository;

    public UserEventHandler(UserprofileRepository userprofileRepository) {
        this.userprofileRepository = userprofileRepository;
    }

    @EventHandler
    public void on(UserCreatedEvent event) {
        System.out.println(event);
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event, userEntity);
        userprofileRepository.save(userEntity);
    }
}
