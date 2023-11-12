package com.example.userprofile.query;

import com.example.userprofile.core.data.UserEntity;
import com.example.userprofile.core.data.UserprofileRepository;
import com.example.userprofile.core.event.UserCreatedEvent;
import com.fasterxml.jackson.databind.util.BeanUtil;
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
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event, userEntity);
        userprofileRepository.save(userEntity);
    }
}
