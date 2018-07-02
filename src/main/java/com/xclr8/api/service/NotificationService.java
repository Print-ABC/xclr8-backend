package com.xclr8.api.service;

import com.xclr8.api.model.Notification;
import com.xclr8.api.repository.NotificationRepository;
import com.xclr8.api.web.response.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationRepository mNotificationRepository;

    /**
     * Return all available notifications from database
     * @return Iterable<NotificationResponse>
     */
    public Iterable<NotificationResponse> findAllNotification(){
        List<Notification> notificationList = mNotificationRepository.findAll();
        return new NotificationResponse().toAllNotificationResponse(notificationList);
    }

    /**
     * Return all available notifications filtered by the given recipient health ID from database
     * @param rhid
     * @return Iterable<NotificationResponse>
     */
    public Iterable<NotificationResponse> findNotificationsByRecipientHealthId(String rhid){
        List<Notification> notificationList = mNotificationRepository.findByHealthId(rhid);
        return new NotificationResponse().toAllNotificationResponse(notificationList);
    }

    /**
     * Delete all notifications filtered by the given docuemnt ID from database
     * @param id
     * @return true
     */
    public boolean deleteNotificationsById(String id) {
        mNotificationRepository.deleteById(id);
        return true;
    }

    /**
     * Delete all notifications filtered by the given recipient health ID from database
     * @param hid
     * @return true
     */
    public boolean deleteNotificationsByRecipientHealthId(String hid) {
        mNotificationRepository.deleteByHealthId(hid);
        return true;
    }
}
