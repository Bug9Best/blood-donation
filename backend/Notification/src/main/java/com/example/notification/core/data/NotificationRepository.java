package com.example.notification.core.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface NotificationRepository extends MongoRepository <NotificationEntity, String> {



    Optional<NotificationEntity> findBy_id(String _id);

    List<NotificationEntity> findByUserid(String userid);


//    List<NotificationEntity> findByUserID(String userid);

//    @Query(value = "{_id:  '?0'}")
//    public NotificationEntity findByID(String id);

//    @Query(value = "{userid:  '?0'}")
//    List<NotificationEntity> findByUserID(String userid);

//    @Query(value = "{header:  '?0'}")
//    public NotificationEntity findByHeader(String header);

}
