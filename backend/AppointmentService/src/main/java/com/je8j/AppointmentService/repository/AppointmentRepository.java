package com.je8j.AppointmentService.repository;

import com.je8j.AppointmentService.pojo.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository  extends MongoRepository <Appointment, String> {

    @Query(value = "{_id : '?0'}")
    public Appointment findByID(String id);

    @Query(value = "{userid : '?0'}")
    public List<Appointment> findByUserId(String userId);

}
