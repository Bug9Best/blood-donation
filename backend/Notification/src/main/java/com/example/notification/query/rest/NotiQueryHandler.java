package com.example.notification.query.rest;


import com.example.notification.core.data.NotificationEntity;
import com.example.notification.core.data.NotificationRepository;
import com.example.notification.query.FindNotiByIdQuery;
import com.example.notification.query.FindNotiByUserIdQuery;
import com.example.notification.query.FindNotiQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotiQueryHandler {

    private final NotificationRepository notificationRepository;

    public NotiQueryHandler(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @QueryHandler
    public List<NotiRestModel> findNoti(FindNotiQuery query){
        List<NotiRestModel> notiRest = new ArrayList<>();
        List<NotificationEntity> storednotification = notificationRepository.findAll();
        for (NotificationEntity notificationEntity : storednotification) {
            NotiRestModel notiRestModel = new NotiRestModel();
            BeanUtils.copyProperties(notificationEntity, notiRestModel);
            notiRest.add(notiRestModel);
        }
        return notiRest;
    }

    @QueryHandler
    public NotiRestModel findNotiById(FindNotiByIdQuery query) {
        NotificationEntity notificationEntity = notificationRepository.findBy_id(query.getNotiId())
                .orElseThrow(() -> new RuntimeException("Noti not found with id : " + query.getNotiId()));

        NotiRestModel notiRestModel = new NotiRestModel();
        BeanUtils.copyProperties(notificationEntity, notiRestModel);

        return notiRestModel;
    }

    @QueryHandler
    public List<NotiRestModel> findNotiByUserId(FindNotiByUserIdQuery query) {
        List<NotiRestModel> notiRest = new ArrayList<>();
        List<NotificationEntity> storednotification = notificationRepository.findByUserid(query.getUserid());

        for (NotificationEntity notificationEntity : storednotification) {
            NotiRestModel notiRestModel = new NotiRestModel();
            BeanUtils.copyProperties(notificationEntity, notiRestModel);
            notiRest.add(notiRestModel);
        }

        return notiRest;
    }

}
