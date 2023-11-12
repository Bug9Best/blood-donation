package com.example.notification.command.rest;

import com.example.notification.command.CreateNotiCommand;
import com.example.notification.command.DeleteNotiCommand;
import com.example.notification.command.UpdateNotiCommand;
import com.example.notification.command.UpdateSeenNotiCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/notifications")
public class NotiCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public NotiCommandController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

//    @RequestMapping(value = "/addNotification", method = RequestMethod.POST)
    @PostMapping
    public String createNotification(@RequestBody CreateNotiRestModel model) {
        CreateNotiCommand command = CreateNotiCommand.builder()
                ._id(UUID.randomUUID().toString())
                .userid(model.getUserid())
                .username(model.getUsername())
                .header(model.getHeader())
                .message(model.getMessage())
                .date(model.getDate())
                .seen(model.isSeen())
                .build();

        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }

        return result;
    }

    // update noti
    @PutMapping("/{id}")
    public String updateNoti(@PathVariable String id, @RequestBody UpdateNotiCommand model) {
        UpdateNotiCommand command = UpdateNotiCommand.builder()
                ._id(id)
                .userid(model.getUserid())
                .username(model.getUsername())
                .header(model.getHeader())
                .message(model.getMessage())
                .date(model.getDate())
                .seen(model.isSeen())
                .build();

        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    // update seen to true
    @PutMapping("/seen/{id}")
    public String updateSeen(@PathVariable String id) {
        UpdateSeenNotiCommand command = UpdateSeenNotiCommand.builder()
                ._id(id)
                .seen(true)
                .build();

        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public String deleteNoti(@PathVariable String id) {
        DeleteNotiCommand command = DeleteNotiCommand.builder()
                ._id(id)
                .build();

        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }





//    Notifications notifications = new Notifications();

//    @RequestMapping(value = "/notifications", method = RequestMethod.GET)
//    public List<Notification> getNotifications() {
//        List<Notification> notificationList = notificationService.retrieveNotification();
//        this.notifications.setModel((ArrayList<Notification>) notificationList);
//
//        return this.notifications.getModel();
//    }
//
//    @RequestMapping(value = "/notification/{userid}")
//    public List<Notification> getNotificationByUserId(@PathVariable("userid") String userid) {
//        List<Notification> notiuserId = notificationService.retrieveNotificationByUserId(userid);
//        return notiuserId;
//    }





//    Lab 8 Create Noti
//    @RequestMapping(value = "/addNotification", method = RequestMethod.POST)
//    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
//
//        Notification create = notificationService.createNotification(notification);
//        return ResponseEntity.ok(create);
//    }




//    @RequestMapping(value = "/deleteNotification/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteNotification(@PathVariable ("id") String id) {
//        Notification notification = notificationService.retrieveNotificationById(id);
//        return ResponseEntity.ok(notificationService.deleteNotification(notification));
//    }
//
//    @RequestMapping(value = "/updateSeen/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateSeen(@PathVariable ("id") String id) {
//        System.out.println("id: " + id);
//        Object updateSeen = notificationService.updateSeen(id);
//        return ResponseEntity.ok(updateSeen);
//    }
}
