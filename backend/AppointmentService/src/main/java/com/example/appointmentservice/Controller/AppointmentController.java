package com.example.appointmentservice.controller;

import com.example.appointmentservice.pojo.Appointment;
import com.example.appointmentservice.repository.AppointmentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, RabbitTemplate rabbitTemplate) {
        this.appointmentService = appointmentService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(value ="/appointment", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAppointment() {
        String test = "test";
        return ResponseEntity.ok(rabbitTemplate.convertSendAndReceive("Appointment", "getallappointment", test));
    }

    @RequestMapping(value ="/appointment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAppointment(@PathVariable String id) {
        return ResponseEntity.ok(rabbitTemplate.convertSendAndReceive("Appointment", "getappointment", id));
    }

    @RequestMapping(value ="/appointment/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createAppointment(@RequestBody Appointment model) {
        Appointment appointment = Appointment.builder()
                .userid(model.getUserid())
                .appointment(model.getAppointment())
                .location(model.getLocation())
                .date(model.getDate())
                .build();

        return ResponseEntity.ok(rabbitTemplate.convertSendAndReceive("Appointment", "createappointment", appointment));
    }

    @RequestMapping(value ="/appointment/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAppointment(@PathVariable String id) {
        return ResponseEntity.ok(rabbitTemplate.convertSendAndReceive("Appointment", "deleteappointment", id));
    }


}
