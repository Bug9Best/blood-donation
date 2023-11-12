package com.example.notification.query;

import com.example.notification.core.data.NotificationEntity;
import com.example.notification.core.data.NotificationRepository;
import com.example.notification.core.event.NotiCreatedEvent;
import com.example.notification.core.event.NotiDeletedEvent;
import com.example.notification.core.event.NotiSeenUpdatedEvent;
import com.example.notification.core.event.NotiUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NotiEventHandler {


    private final NotificationRepository notificationRepository;

    public NotiEventHandler(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @EventHandler
    public void on(NotiCreatedEvent event) {
        NotificationEntity notificationEntity = new NotificationEntity();
        BeanUtils.copyProperties(event, notificationEntity);
        notificationRepository.save(notificationEntity);
    }

    @EventHandler
    public void on(NotiSeenUpdatedEvent event) {
        NotificationEntity notificationEntity = notificationRepository.findBy_id(event.get_id())
                .orElseThrow(() -> new RuntimeException("Not found"));

        notificationEntity.setSeen(true);
        notificationRepository.save(notificationEntity);

    }

    @EventHandler
    public void on (NotiUpdatedEvent event) {
        NotificationEntity notificationEntity = notificationRepository.findBy_id(event.get_id())
                .orElseThrow(() -> new RuntimeException("Not Found"));

        notificationEntity.setUserid(event.getUserid());
        notificationEntity.setUsername(event.getUsername());
        notificationEntity.setHeader(event.getHeader());
        notificationEntity.setMessage(event.getMessage());
        notificationEntity.setDate(event.getDate());
        notificationEntity.setSeen(event.isSeen());
        notificationRepository.save(notificationEntity);
    }

    @EventHandler
    public void on (NotiDeletedEvent event) {
        NotificationEntity notificationEntity = notificationRepository.findBy_id(event.get_id())
                .orElseThrow(() -> new RuntimeException("Not Found"));


        notificationRepository.delete(notificationEntity);




    }
}
