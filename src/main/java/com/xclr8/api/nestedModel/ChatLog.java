package com.xclr8.api.nestedModel;


import lombok.Data;

@Data
public class ChatLog {
    /**
     ChatLog object to be stored in the Chat objects in the database
     */

    private String sender;
    private String recipient;
    private String text;
}
