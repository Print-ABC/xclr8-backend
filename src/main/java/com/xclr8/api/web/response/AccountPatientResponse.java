package com.xclr8.api.web.response;

import com.xclr8.api.model.Account;
import com.xclr8.api.model.Patient;
import lombok.Data;

@Data
public class AccountPatientResponse {
    private String id;
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

    /**
     * Create an AccountPatientResponse from an Account and Patient object and return it
     * @param account
     * @param patient
     * @return accountPatientResponse
     */
    public AccountPatientResponse accountPatientResponse(Account account, Patient patient){
        AccountPatientResponse accountPatientResponse = new AccountPatientResponse();
        accountPatientResponse.setPassword(account.getPassword());
        accountPatientResponse.setAccountType(1);
        accountPatientResponse.setHealthId(account.getHealthId());
        accountPatientResponse.setFirstName(account.getFirstName());
        accountPatientResponse.setLastName(account.getLastName());
        accountPatientResponse.setEmail(account.getEmail());
        accountPatientResponse.setMobileNo(account.getMobileNo());
        accountPatientResponse.setHeight(patient.getHeight());
        accountPatientResponse.setWeight(patient.getWeight());
        accountPatientResponse.setGender(patient.getGender());
        accountPatientResponse.setDob(patient.getDob());
        accountPatientResponse.setStreetBuildingName(patient.getStreetBuildingName());
        accountPatientResponse.setPostalCode(patient.getPostalCode());
        accountPatientResponse.setCity(patient.getCity());
        accountPatientResponse.setCountry(patient.getCountry());
        accountPatientResponse.setFixedLineNo(patient.getFixedLineNo());
        accountPatientResponse.setInsuranceCompany(patient.getInsuranceCompany());
        accountPatientResponse.setInsurancePolicyNo(patient.getInsurancePolicyNo());
        accountPatientResponse.setTherapistId(patient.getTherapistId());

        return accountPatientResponse;
    }

    /**
     * Create an AccountPatientResponse from an Account and Patient object and return it but with the patient ID, for editing patient details
     * @param account
     * @param patient
     * @return accountPatientResponse
     */
    public AccountPatientResponse accountPatientEditResponse(Account account, Patient patient){
        AccountPatientResponse accountPatientResponse = new AccountPatientResponse();
        accountPatientResponse.setId(patient.getId());
        accountPatientResponse.setPassword(account.getPassword());
        accountPatientResponse.setHealthId(account.getHealthId());
        accountPatientResponse.setFirstName(account.getFirstName());
        accountPatientResponse.setLastName(account.getLastName());
        accountPatientResponse.setEmail(account.getEmail());
        accountPatientResponse.setMobileNo(account.getMobileNo());
        accountPatientResponse.setHeight(patient.getHeight());
        accountPatientResponse.setWeight(patient.getWeight());
        accountPatientResponse.setGender(patient.getGender());
        accountPatientResponse.setDob(patient.getDob());
        accountPatientResponse.setStreetBuildingName(patient.getStreetBuildingName());
        accountPatientResponse.setPostalCode(patient.getPostalCode());
        accountPatientResponse.setCity(patient.getCity());
        accountPatientResponse.setCountry(patient.getCountry());
        accountPatientResponse.setFixedLineNo(patient.getFixedLineNo());
        accountPatientResponse.setInsuranceCompany(patient.getInsuranceCompany());
        accountPatientResponse.setInsurancePolicyNo(patient.getInsurancePolicyNo());

        return accountPatientResponse;
    }
}
