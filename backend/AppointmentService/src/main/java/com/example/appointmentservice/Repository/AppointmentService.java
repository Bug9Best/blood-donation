package com.example.appointmentservice.Repository;


import com.example.appointmentservice.Pojo.Appointment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    @Autowired
    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "GetAppointment")
    public List<Appointment> getAppointment(String id) {
        return repository.findByUserId(id);
    }

    @RabbitListener(queues = "GetAllAppointment")
    public List<Appointment> getAllAppointment(String id) {
        List<Appointment> test = repository.findAll();
        System.out.println(test);
        return test;
    }

    @RabbitListener(queues = "CreateAppointment")
    public Appointment createAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    @RabbitListener(queues = "DeleteAppointment")
    public void deleteAppointment(String id) {
        Appointment item = repository.findByID(id);
        repository.delete(item);
    }
}
