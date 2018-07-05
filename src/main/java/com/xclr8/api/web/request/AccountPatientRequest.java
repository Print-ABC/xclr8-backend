package com.xclr8.api.web.request;

import lombok.Data;

@Data
public class AccountPatientRequest {
    private String password;
    private int accountType = 1;
    private String healthId;
    private String firstName;
    private String lastName;
    private Double height;
    private Double weight;
    private String gender;
    private String dob;
    private String streetBuildingName;
    private int postalCode;
    private String city;
    private String country;
    private String email;
    private int mobileNo;
    private int fixedLineNo;
    private int emergencyNo;
    private String insuranceCompany;
    private String insurancePolicyNo;
    private String therapistId;
}
