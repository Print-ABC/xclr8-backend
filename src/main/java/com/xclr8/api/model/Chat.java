package com.xclr8.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "Chat")
public class Chat {
    @Id
    private String id;

    @Field
    private String therapist_healthId;

    @Field
    private String patient_healthId;

    @Field
    private List<ChatLog> chatLog;
}
