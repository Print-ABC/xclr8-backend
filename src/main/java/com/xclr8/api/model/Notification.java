package com.xclr8.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Notification")
public class Notification {
    @Id
    private String id;

    @Field
    private String healthId;

    @Field
    private String timeStamp;

    @Field
    private String title;

    @Field
    private String message;

    @Field
    private int status;

}
