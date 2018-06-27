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
    private String height;

    @Field
    private String weight;

    @Field
    private String gender;

    @Field
    private String dob;

    @Field
    private String streetAndBuildingName;

    @Field
    private int postalCode;

    @Field
    private String city;

    @Field
    private String country;

    @Field
    private String email;

    @Field
    private int mobileNo;

    @Field
    private int fixedLineNo;

    @Field
    private int emergencyNo;

    @Field
    private String insuranceCompany;

    @Field
    private String insurancePolicyNo;

    @Field
    private String therapistId;
}
