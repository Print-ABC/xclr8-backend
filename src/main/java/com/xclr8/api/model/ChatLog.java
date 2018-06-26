package com.xclr8.api.model;


import lombok.Data;

@Data
public class ChatLog {
    private String sender;
    private String recipient;
    private String text;
}
