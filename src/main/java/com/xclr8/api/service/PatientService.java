package com.xclr8.api.service;

import com.xclr8.api.model.Patient;
import com.xclr8.api.repository.PatientRepository;
import com.xclr8.api.web.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository mPatientRepository;

    /**
     * Return information of all patients from database
     * @return Iterable<PatientResponse>
     */
    public Iterable<PatientResponse> findAllPatients(){
        List<Patient> patientList = mPatientRepository.findAll();
        return new PatientResponse().toAllPatientResponse(patientList);
    }

    /**
     * Return information of a patient with the given health ID from database
     * @param hid
     * @return PatientResponse
     */
    public PatientResponse findPatientByHealthId(String hid) {
        Patient patient = mPatientRepository.findByHealthId(hid);
        return new PatientResponse().response(patient);
    }

    /**
     * Return information of a patient with the given first name from database
     * @param firstName
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByFirstName(String firstName) {
        List<Patient> patientList = mPatientRepository.findByFirstName(firstName);
        return new PatientResponse().toAllPatientResponse(patientList);
    }

    /**
     * Return information of a patient with the given last name from database
     * @param lastName
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByLastName(String lastName) {
        List<Patient> patientList = mPatientRepository.findByLastName(lastName);
        return new PatientResponse().toAllPatientResponse(patientList);
    }

}
