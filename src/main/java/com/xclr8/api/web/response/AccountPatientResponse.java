package com.xclr8.api.web.response;

import com.xclr8.api.model.Account;
import com.xclr8.api.model.Patient;
import lombok.Data;

@Data
public class AccountPatientResponse {
    private String password;
    private int accountType = 1;
    private String healthId;
    private String firstName;
    private String lastName;
    private Double height;
    private Double weight;
    private String gender;
    private String dob;
    private String streetAndBuildingName;
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

    public static AccountPatientResponse createCheck(Account a, Patient p){
        AccountPatientResponse accountPatientResponse = new AccountPatientResponse();
        accountPatientResponse.setPassword(a.getPassword());
        accountPatientResponse.setAccountType(1);
        accountPatientResponse.setHealthId(a.getHealthId());
        accountPatientResponse.setFirstName(a.getFirstName());
        accountPatientResponse.setLastName(a.getLastName());
        accountPatientResponse.setEmail(a.getEmail());
        accountPatientResponse.setMobileNo(a.getMobileNo());
        accountPatientResponse.setHeight(p.getHeight());
        accountPatientResponse.setWeight(p.getWeight());
        accountPatientResponse.setGender(p.getGender());
        accountPatientResponse.setDob(p.getDob());
        accountPatientResponse.setStreetAndBuildingName(p.getStreetAndBuildingName());
        accountPatientResponse.setPostalCode(p.getPostalCode());
        accountPatientResponse.setCity(p.getCity());
        accountPatientResponse.setCountry(p.getCountry());
        accountPatientResponse.setFixedLineNo(p.getFixedLineNo());
        accountPatientResponse.setInsuranceCompany(p.getInsuranceCompany());
        accountPatientResponse.setInsurancePolicyNo(p.getInsurancePolicyNo());
        accountPatientResponse.setTherapistId(p.getTherapistId());

        return accountPatientResponse;
    }

}
