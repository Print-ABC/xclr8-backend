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
    private String healthId;

    @Field
    private String firstName;

    @Field
    private String lastName;

    @Field
    private Double height;

    @Field
    private Double weight;

    @Field
    private String gender;

    @Field
    private String dob;

    @Field
    private String streetBuildingName;

    @Field
    private String postalCode;

    @Field
    private String city;

    @Field
    private String country;

    @Field
    private String email;

    @Field
    private String mobileNo;

    @Field
    private String fixedLineNo;

    @Field
    private String emergencyNo;

    @Field
    private String insuranceCompany;

    @Field
    private String insurancePolicyNo;

    @Field
    private String therapistId;
}
