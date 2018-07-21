package com.xclr8.api.web.request;

import lombok.Data;

@Data
public class ChatRequest {
    private String id;
    private String therapistHealthId;
    private String patientHealthId;
    private String sender;
    private String recipient;
    private String text;
}
