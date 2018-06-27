package com.xclr8.api.web.response;

import com.xclr8.api.model.Patient;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PatientResponse {
    private String id;
    private String healthId;
    private String firstName;
    private String lastName;
    private String height;
    private String weight;
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

    /**
     * Create an PatientResponse from an Patient object and return it
     * @param patient
     * @return pR
     */
    public PatientResponse response(Patient patient) {
        PatientResponse pR = new PatientResponse();
        pR.setId(patient.getId());
        pR.setHealthId(patient.getHealthId());
        pR.setFirstName(patient.getFirstName());
        pR.setLastName(patient.getLastName());
        pR.setHeight(patient.getHeight());
        pR.setWeight(patient.getWeight());
        pR.setGender(patient.getGender());
        pR.setDob(patient.getDob());
        pR.setStreetAndBuildingName(patient.getStreetAndBuildingName());
        pR.setPostalCode(patient.getPostalCode());
        pR.setCity(patient.getCity());
        pR.setCountry(patient.getCountry());
        pR.setEmail(patient.getEmail());
        pR.setMobileNo(patient.getMobileNo());
        pR.setFixedLineNo(patient.getFixedLineNo());
        pR.setEmergencyNo(patient.getEmergencyNo());
        pR.setInsuranceCompany(patient.getInsuranceCompany());
        pR.setInsurancePolicyNo(patient.getInsurancePolicyNo());
        pR.setTherapistId(patient.getTherapistId());
        return pR;
    }

    /**
     * Create a list of PatientResponse from Patient objects and return it
     * @param pList
     * @return pRList
     */
    public Iterable<PatientResponse> toAllPatientResponse(Iterable<Patient> pList){
        ArrayList<PatientResponse> pRList = new ArrayList<PatientResponse>();
        for (Patient p : pList) {
            PatientResponse pR = new PatientResponse();
            pR.setId(p.getId());
            pR.setHealthId(p.getHealthId());
            pR.setFirstName(p.getFirstName());
            pR.setLastName(p.getLastName());
            pR.setHeight(p.getHeight());
            pR.setWeight(p.getWeight());
            pR.setGender(p.getGender());
            pR.setDob(p.getDob());
            pR.setStreetAndBuildingName(p.getStreetAndBuildingName());
            pR.setPostalCode(p.getPostalCode());
            pR.setCity(p.getCity());
            pR.setCountry(p.getCountry());
            pR.setEmail(p.getEmail());
            pR.setMobileNo(p.getMobileNo());
            pR.setFixedLineNo(p.getFixedLineNo());
            pR.setEmergencyNo(p.getEmergencyNo());
            pR.setInsuranceCompany(p.getInsuranceCompany());
            pR.setInsurancePolicyNo(p.getInsurancePolicyNo());
            pR.setTherapistId(p.getTherapistId());
            pRList.add(pR);
        }

        return pRList;
    }

}
