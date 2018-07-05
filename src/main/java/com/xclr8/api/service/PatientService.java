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
     * Return information of a patient with the given first name from database
     * @param firstName
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByFirstName(String firstName) {
        List<Patient> patientList = mPatientRepository.findByFirstName(firstName);
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Return information of a patient with the given last name from database
     * @param lastName
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByLastName(String lastName) {
        List<Patient> patientList = mPatientRepository.findByLastName(lastName);
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Return information of a patient with the given street and building name from database
     * @param streetBuildingName
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByStreetBuildingName(String streetBuildingName) {
        List<Patient> patientList = mPatientRepository.findByStreetBuildingName(streetBuildingName);
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Return information of a patient with the given postal code from database
     * @param postalCode
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByPostalCode(int postalCode) {
        List<Patient> patientList = mPatientRepository.findByPostalCode(postalCode);
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Return information of a patient with the given city from database
     * @param city
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByCity(String city) {
        List<Patient> patientList = mPatientRepository.findByCity(city);
        return new PatientResponse().patientResponseIterable(patientList);
    }

    /**
     * Return information of a patient with the given country from database
     * @param country
     * @return PatientResponse
     */
    public Iterable<PatientResponse> findPatientByCountry(String country) {
        List<Patient> patientList = mPatientRepository.findByCountry(country);
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
