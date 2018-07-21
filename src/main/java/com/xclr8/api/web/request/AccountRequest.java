package com.xclr8.api.web.request;

import lombok.Data;

@Data
public class AccountRequest {
    private String healthId;
    private String firstName;
    private String lastName;
    private String height;
    private String weight;
    private String gender;
    private String dob;
    private String streetAndBuildingName;
    private String postalCode;
    private String city;
    private String country;
    private String email;
    private String mobileNo;
    private String fixedLineNo;
    private String emergencyNo;
    private String insuranceCompany;
    private String insurancePolicyNo;
    private String therapistId;

}
