package com.xclr8.api.web.controller;

import com.xclr8.api.service.PatientService;
import com.xclr8.api.web.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService mPatientService;

    /**
     * GET [url]:8080/patient/all
     * Return information of all patients from database
     * @return Iterable<PatientResponse>
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<PatientResponse> patients() {
        return mPatientService.findAllPatients();
    }

    /**
     * GET [url]:8080/patient/hid/[health Id]
     * Return information of a patient with the given health ID from database
     * @param hid
     * @return PatientResponse
     */
    @RequestMapping(value = "/hid/{hid}", method = RequestMethod.GET)
    public PatientResponse patientByHealthId(@PathVariable String hid) {
        return mPatientService.findPatientByHealthId(hid);
    }

    /**
     * GET [url]:8080/patient/fname/[first name]
     * Return information of all patients with the given first name from database
     * @param fname
     * @return PatientResponse
     */
    @RequestMapping(value = "/fname/{fname}", method = RequestMethod.GET)
    public Iterable<PatientResponse> patientByFirstName(@PathVariable String fname) {
        return mPatientService.findPatientByFirstName(fname);
    }

    /**
     * GET [url]:8080/patient/lname/[last name]
     * Return information of all patients with the given last name from database
     * @param lname
     * @return PatientResponse
     */
    @RequestMapping(value = "/lname/{lname}", method = RequestMethod.GET)
    public Iterable<PatientResponse> patientByLastName(@PathVariable String lname) {
        return mPatientService.findPatientByLastName(lname);
    }

//    /**
//     * GET [url]:8080/patient/sbn/[street and building name]
//     * Return information of all patients filtered by street and building name from database
//     * @param streetBuildingName
//     * @return Iterable<PatientResponse>
//     */
//    @RequestMapping(value = "/sbn/{streetBuildingName}", method = RequestMethod.GET)
//    public Iterable<PatientResponse> patientByStreetBuildingName(@PathVariable String streetBuildingName) {
//        return mPatientService.findPatientByStreetBuildingName(streetBuildingName);
//    }

    /**
     * GET [url]:8080/patient/pcode/[postal code]
     * Return information of all patients filtered by postal code from database
     * @param postalCode
     * @return Iterable<PatientResponse>
     */
    @RequestMapping(value = "/pcode/{postalCode}", method = RequestMethod.GET)
    public Iterable<PatientResponse> patientByPostalCode(@PathVariable int postalCode) {
        return mPatientService.findPatientByPostalCode(postalCode);
    }

    /**
     * GET [url]:8080/patient/city/[city]
     * Return information of all patients filtered by city from database
     * @param city
     * @return Iterable<PatientResponse>
     */
    @RequestMapping(value = "/city/{city}", method = RequestMethod.GET)
    public Iterable<PatientResponse> patientByCity(@PathVariable String city) {
        return mPatientService.findPatientByCity(city);
    }

    /**
     * GET [url]:8080/patient/country/[country]
     * Return information of all patients filtered by country from database
     * @param country
     * @return Iterable<PatientResponse>
     */
    @RequestMapping(value = "/country/{country}", method = RequestMethod.GET)
    public Iterable<PatientResponse> patientByCountry(@PathVariable String country) {
        return mPatientService.findPatientByCountry(country);
    }

    /**
     * DELETE [url]:8080/patient/delete/[health Id]
     * @param hid
     * @return
     */
    @RequestMapping(value = "/delete/{hid}", method = RequestMethod.DELETE)
    public boolean deletePatientByHealthId(@PathVariable String hid) {
        return mPatientService.deletePatientByHealthId(hid);
    }
}
