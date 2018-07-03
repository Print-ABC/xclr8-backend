package com.xclr8.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Patient_statistics")
public class Patient_statistics {
    @Id
    String id;

    @Field
    String patientId;

    @Field
    double improvementROM;

    @Field
    //0 = Non-compliant, 1 = Compliant
    int complianceStatus;

    @Field
    double complianceRating;
}
