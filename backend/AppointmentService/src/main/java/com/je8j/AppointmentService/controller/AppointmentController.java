package com.je8j.AppointmentService.controller;

import com.je8j.AppointmentService.pojo.Appointment;
import com.je8j.AppointmentService.repository.AppointmentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(rabbitTemplate.convertSendAndReceive("Appointment", "getallappointment", "eiei"));
    }

    @RequestMapping(value ="/appointment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAppointment(@PathVariable String id) {
        return ResponseEntity.ok(rabbitTemplate.convertSendAndReceive("Appointment", "getappointment", id));
    }

    @RequestMapping(value ="/appointment/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        System.out.println(appointment);
        return ResponseEntity.ok(rabbitTemplate.convertSendAndReceive("Appointment", "createappointment", appointment));
    }

    @RequestMapping(value ="/appointment/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAppointment(@PathVariable String id) {
        return ResponseEntity.ok(rabbitTemplate.convertSendAndReceive("Appointment", "deleteappointment", id));
    }


}
