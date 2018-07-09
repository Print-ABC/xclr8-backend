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
    private String therapistId;

    /**
     * Create an PatientResponse from an Patient object and return it
     * @param patient
     * @return patientResponse
     */
    public PatientResponse patientResponse(Patient patient) {
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(patient.getId());
        patientResponse.setHealthId(patient.getHealthId());
        patientResponse.setFirstName(patient.getFirstName());
        patientResponse.setLastName(patient.getLastName());
        patientResponse.setHeight(patient.getHeight());
        patientResponse.setWeight(patient.getWeight());
        patientResponse.setGender(patient.getGender());
        patientResponse.setDob(patient.getDob());
        patientResponse.setStreetBuildingName(patient.getStreetBuildingName());
        patientResponse.setPostalCode(patient.getPostalCode());
        patientResponse.setCity(patient.getCity());
        patientResponse.setCountry(patient.getCountry());
        patientResponse.setEmail(patient.getEmail());
        patientResponse.setMobileNo(patient.getMobileNo());
        patientResponse.setFixedLineNo(patient.getFixedLineNo());
        patientResponse.setEmergencyNo(patient.getEmergencyNo());
        patientResponse.setInsuranceCompany(patient.getInsuranceCompany());
        patientResponse.setInsurancePolicyNo(patient.getInsurancePolicyNo());
        patientResponse.setTherapistId(patient.getTherapistId());
        return patientResponse;
    }

    /**
     * Create a list of PatientResponse from Patient objects and return it
     * @param patients
     * @return patientResponses
     */
    public Iterable<PatientResponse> patientResponseIterable(Iterable<Patient> patients){
        ArrayList<PatientResponse> patientResponses = new ArrayList<PatientResponse>();
        for (Patient p : patients) {
            PatientResponse patientResponse = new PatientResponse();
            patientResponse.setId(p.getId());
            patientResponse.setHealthId(p.getHealthId());
            patientResponse.setFirstName(p.getFirstName());
            patientResponse.setLastName(p.getLastName());
            patientResponse.setHeight(p.getHeight());
            patientResponse.setWeight(p.getWeight());
            patientResponse.setGender(p.getGender());
            patientResponse.setDob(p.getDob());
            patientResponse.setStreetBuildingName(p.getStreetBuildingName());
            patientResponse.setPostalCode(p.getPostalCode());
            patientResponse.setCity(p.getCity());
            patientResponse.setCountry(p.getCountry());
            patientResponse.setEmail(p.getEmail());
            patientResponse.setMobileNo(p.getMobileNo());
            patientResponse.setFixedLineNo(p.getFixedLineNo());
            patientResponse.setEmergencyNo(p.getEmergencyNo());
            patientResponse.setInsuranceCompany(p.getInsuranceCompany());
            patientResponse.setInsurancePolicyNo(p.getInsurancePolicyNo());
            patientResponse.setTherapistId(p.getTherapistId());
            patientResponses.add(patientResponse);
        }
        return patientResponses;
    }

}
