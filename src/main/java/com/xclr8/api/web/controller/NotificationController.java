package com.xclr8.api.web.controller;

import com.xclr8.api.service.NotificationService;
import com.xclr8.api.web.response.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService mNotificationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<NotificationResponse> notifications() {
        return mNotificationService.findAllChat();
    }
}