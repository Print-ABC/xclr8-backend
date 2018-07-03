package com.xclr8.api.web.request;

import lombok.Data;

@Data
public class NotificationRequest {
    private String id;
    private String healthId;
    private String timeStamp;
    private String title;
    private String message;
    private int status;
}
