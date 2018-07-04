package com.xclr8.api.web.response;

import com.xclr8.api.model.Notification;
import lombok.Data;

import java.util.ArrayList;

@Data
public class NotificationResponse {
    private String id;
    private String healthId;
    private String timeStamp;
    private String title;
    private String message;
    private int status;

    /**
     * Create a list of NotificationResponse from Notification objects and return it
     * @param notifications
     * @return notificationResponses
     */
    public Iterable<NotificationResponse> notificationResponseIterable(Iterable<Notification> notifications){
        ArrayList<NotificationResponse> notificationResponses = new ArrayList<NotificationResponse>();
        for (Notification n : notifications) {
            NotificationResponse notificationResponse = new NotificationResponse();
            notificationResponse.setId(n.getId());
            notificationResponse.setHealthId(n.getHealthId());
            notificationResponse.setTimeStamp(n.getTimeStamp());
            notificationResponse.setTitle(n.getTitle());
            notificationResponse.setMessage(n.getMessage());
            notificationResponse.setStatus(n.getStatus());
            notificationResponses.add(notificationResponse);
        }
        return notificationResponses;
    }

    /**
     * Create a NotificationResponse from Notification objects and return it
     * @param notification
     * @return notificationResponse
     */
    public NotificationResponse notificationResponse(Notification notification){
        NotificationResponse notificationResponse = new NotificationResponse();
        notificationResponse.setId(notification.getId());
        notificationResponse.setHealthId(notification.getHealthId());
        notificationResponse.setTimeStamp(notification.getTimeStamp());
        notificationResponse.setTitle(notification.getTitle());
        notificationResponse.setMessage(notification.getMessage());
        notificationResponse.setStatus(notification.getStatus());
        return notificationResponse;
    }

}
