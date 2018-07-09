package com.xclr8.api.web.request;

import lombok.Data;

@Data
public class AccountPatientRequest {
    private int accountType = 1;
    private String password;
    private String firstName;
    private String lastName;
    private Double height;
    private Double weight;
    private String gender;
    private String dob;
    private String streetBuildingName;
    private String postalCode;
    private String city;
    private String country;
    private String email;
    private String mobileNo;
    private String fixedLineNo;
    private String emergencyNo;
    private String insuranceCompany;
    private String insurancePolicyNo;

    //Data not obtained from create patient screen! Therapist ID is the health id of the therapist that's creating the patient account.
    private String therapistId;

    //Data has to generated on the android side before putting in here
    private String healthId;
}
