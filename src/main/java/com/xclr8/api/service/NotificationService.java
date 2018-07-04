package com.xclr8.api.service;

import com.xclr8.api.model.Notification;
import com.xclr8.api.repository.NotificationRepository;
import com.xclr8.api.web.request.NotificationRequest;
import com.xclr8.api.web.response.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return new NotificationResponse().notificationResponseIterable(notificationList);
    }

    /**
     * Return all available notifications filtered by the given recipient health ID from database
     * @param rhid
     * @return Iterable<NotificationResponse>
     */
    public Iterable<NotificationResponse> findNotificationsByRecipientHealthId(String rhid){
        List<Notification> notificationList = mNotificationRepository.findByHealthId(rhid);
        return new NotificationResponse().notificationResponseIterable(notificationList);
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

    /**
     * Creates a Notification object in the database
     * @param notificationRequest
     * @return NotificationResponse
     */
    public NotificationResponse createNotification(NotificationRequest notificationRequest){
        Notification notification = new Notification();
        notification.setHealthId(notificationRequest.getHealthId());
        notification.setMessage(notificationRequest.getMessage());
        notification.setTitle(notificationRequest.getTitle());
        notification.setTimeStamp(notificationRequest.getTimeStamp());
        notification.setStatus(notificationRequest.getStatus());

        mNotificationRepository.save(notification);
        return new NotificationResponse().notificationResponse(notification);
    }

    /**
     * Marks a notification as read in the database.
     * 0 = Unread;
     * 1 = Read.
     * @param id
     * @return NotificationResponse
     */
    public NotificationResponse readNotification(String id){
        Notification notification = new Notification();
        Optional<Notification> notificationCheck = mNotificationRepository.findById(id);
        if (notificationCheck.isPresent()){
            notification = notificationCheck.get();
            notification.setStatus(1);
            mNotificationRepository.save(notification);
        } else {
            //Return error message
        }

        return new NotificationResponse().notificationResponse(notification);
    }

    /**
     * Marks a notification as read in the database.
     * 0 = Unread;
     * 1 = Read.
     * @param hid
     * @return NotificationResponse
     */
    public Iterable<NotificationResponse> readAllNotifications(String hid){
        List<Notification> notificationsList = mNotificationRepository.findByHealthId(hid);

        for (Notification n : notificationsList) {
            n.setStatus(1);
        }

        mNotificationRepository.saveAll(notificationsList);

        return new NotificationResponse().notificationResponseIterable(notificationsList);
    }
}
