package com.xclr8.api.web.controller;

import com.xclr8.api.model.Notification;
import com.xclr8.api.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationRepository mNotificationRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Notification> notifications() {
        return mNotificationRepository.findAll();
    }
}
