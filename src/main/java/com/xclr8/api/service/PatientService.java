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
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Return information of a patient with the given health ID from database
     * @param hid
     * @return PatientResponse
     */
    public PatientResponse findPatientByHealthId(String hid) {
        Patient patient = mPatientRepository.findByHealthId(hid);
        return new PatientResponse().patientResponse(patient);
    }

    /**
     * Return patients based on string search of first and last names from database
     * @param nameRegex
     * @return Iterable<PatientResponse>
     */
    public Iterable<PatientResponse> findPatientByName(String nameRegex) {
        List<Patient> patientList = mPatientRepository.findPatientByName(nameRegex);
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Return patients based on string search of first name from database
     * @param fNameRegex
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByFirstName(String fNameRegex) {
        List<Patient> patientList = mPatientRepository.findPatientByFirstName(fNameRegex);
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Return patients based on string search of last name from database
     * @param lNameRegex
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByLastName(String lNameRegex) {
        List<Patient> patientList = mPatientRepository.findPatientByLastName(lNameRegex);
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Return patients based on string search of street and building name, postal code, city, and country from database
     * @param locationRegex
     * @return Iterable<PatientResponse>
     */
    public Iterable<PatientResponse> findPatientByLocation(String locationRegex) {
        List<Patient> patientList = mPatientRepository.findPatientByLocation(locationRegex);
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Delete a patient with the given health ID
     * @param hid
     * @return true
     */
    public boolean deletePatientByHealthId(String hid) {
        mPatientRepository.deleteByHealthId(hid);
        return true;
    }
}
