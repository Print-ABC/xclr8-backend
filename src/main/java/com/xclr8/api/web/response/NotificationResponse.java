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
     * @param nList
     * @return nRList
     */
    public Iterable<NotificationResponse> toAllNotificationResponse(Iterable<Notification> nList){
        ArrayList<NotificationResponse> nRList = new ArrayList<NotificationResponse>();
        for (Notification n : nList) {
            NotificationResponse nR = new NotificationResponse();
            nR.setId(n.getId());
            nR.setHealthId(n.getHealthId());
            nR.setTimeStamp(n.getTimeStamp());
            nR.setTitle(n.getTitle());
            nR.setMessage(n.getMessage());
            nR.setStatus(n.getStatus());
            nRList.add(nR);
        }

        return nRList;
    }

}
