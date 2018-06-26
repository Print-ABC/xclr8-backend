package com.xclr8.api.service;

import com.xclr8.api.model.Notification;
import com.xclr8.api.repository.NotificationRepository;
import com.xclr8.api.web.response.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    public Iterable<NotificationResponse> findAllChat(){
        List<Notification> nList;
        nList = notificationRepository.findAll();
        return NotificationResponse.toAllNotificationResponse(nList);
    }
}
