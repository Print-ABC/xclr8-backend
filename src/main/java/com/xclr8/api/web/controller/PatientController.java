package com.xclr8.api.web.controller;

import com.xclr8.api.service.CreateService;
import com.xclr8.api.service.PatientService;
import com.xclr8.api.web.request.AccountPatientRequest;
import com.xclr8.api.web.response.AccountPatientResponse;
import com.xclr8.api.web.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService mPatientService;
    @Autowired
    CreateService mCreateService;

    /**
     * GET [url]:8080/patient
     * Return information of all patients from database
     * @return Iterable<PatientResponse>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<PatientResponse> patients() {
        return mPatientService.findAllPatients();
    }

    /**
     * GET [url]:8080/patient/[health Id]
     * Return information of a patient with the given health ID from database
     * @param hid
     * @return PatientResponse
     */
    @RequestMapping(value = "/{hid}", method = RequestMethod.GET)
    public PatientResponse patientByHealthId(@PathVariable String hid) {
        return mPatientService.findPatientByHealthId(hid);
    }

    /**
     * Return information of patients based on a string search of first and last names from database
     * @param name
     * @return Iterable<PatientResponse>
     */
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Iterable<PatientResponse> patientByName(@PathVariable String name) {
        return mPatientService.findPatientByName(".*" + name + ".*");
    }

    /**
     * GET [url]:8080/patient/first-name/[first name]
     * Return patients based on string search of first name from database
     * @param fname
     * @return PatientResponse
     */
    @RequestMapping(value = "/first-name/{fname}", method = RequestMethod.GET)
    public Iterable<PatientResponse> patientByFirstName(@PathVariable String fname) {
        return mPatientService.findPatientByFirstName(".*" + fname + ".*");
    }

    /**
     * GET [url]:8080/patient/last-name/[last name]
     * Return patients based on string search of last name from database
     * @param lname
     * @return PatientResponse
     */
    @RequestMapping(value = "/last-name/{lname}", method = RequestMethod.GET)
    public Iterable<PatientResponse> patientByLastName(@PathVariable String lname) {
        return mPatientService.findPatientByLastName(".*" + lname + ".*");
    }

    /**
     * GET [url]:8080/patient/location/[str]
     * Return patients based on string search of street and building name, postal code, city, and country from database
     * @param str
     * @return Iterable<PatientResponse>
     */
    @RequestMapping(value = "/location/{str}", method = RequestMethod.GET)
    public Iterable<PatientResponse> patientByLocation(@PathVariable String str) {
        return mPatientService.findPatientByLocation(".*" + str + ".*");
    }

    /**
     * PUT [url]:8080/patient
     * Edits a patient object in the database
     * @param patient
     * @return AccountPatientResponse
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public AccountPatientResponse editPatient(@RequestBody AccountPatientRequest patient) {
        return mCreateService.editPatient(patient);
    }

    /**
     * DELETE [url]:8080/patient/[health Id]
     * Delete a patient with the given health ID
     * @param hid
     * @return
     */
    @RequestMapping(value = "/{hid}", method = RequestMethod.DELETE)
    public boolean deletePatientByHealthId(@PathVariable String hid) {
        return mPatientService.deletePatientByHealthId(hid);
    }
}
