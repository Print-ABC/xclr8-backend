package com.xclr8.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "test")
public class Test {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field
    private String name;
}
