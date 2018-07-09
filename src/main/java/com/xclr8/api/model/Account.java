package com.xclr8.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Account")
public class Account {
    @Id
    private String id;

    @Field
    private String healthId;

    @Field
    private String email;

    @Field
    private String mobileNo;

    @Field
    private String password;

    @Field
    private int accountType;

    @Field
    private String firstName;

    @Field
    private String lastName;
}
