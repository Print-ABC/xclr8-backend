package com.xclr8.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Patient")
public class Patient {
    @Id
    private String id;

    @Field
    private String patient_Id;

    @Field
    private String firstName;

    @Field
    private String lastName;
}
