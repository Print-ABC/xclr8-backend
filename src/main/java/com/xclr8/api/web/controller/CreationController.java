package com.xclr8.api.web.controller;

import com.xclr8.api.service.CreationService;
import com.xclr8.api.web.request.AccountPatientRequest;
import com.xclr8.api.web.request.AccountTherapistRequest;
import com.xclr8.api.web.response.AccountPatientResponse;
import com.xclr8.api.web.response.AccountTherapistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class CreationController {

    @Autowired
    CreationService mCreateService;

    /**
     * POST [url]:8080/create/patient
     * Creates a patient object in the database
     * @param patient
     * @return AccountPatientResponse
     */
    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public AccountPatientResponse createPatient(@RequestBody AccountPatientRequest patient) {
//        if (mAccountService.findAccByHealthId(patient.getHealthId()) != null) {
//            AccountPatientResponse errorMsg = new AccountPatientResponse();
//            errorMsg.setHealthId("Health ID already exists");
//            return errorMsg;
//        }
//        else {
            return mCreateService.createPatientAccount(patient);
//        }
    }

    /**
     * POST [url]:8080/create/therapist
     * Creates a therapist object in the database
     * @param therapist
     * @return AccountTherapistResponse
     */
    @RequestMapping(value = "/therapist", method = RequestMethod.POST)
    public AccountTherapistResponse createTherapist(@RequestBody AccountTherapistRequest therapist) {
//        if (mAccountService.findAccByHealthId(patient.getHealthId()) != null) {
//            AccountPatientResponse errorMsg = new AccountPatientResponse();
//            errorMsg.setHealthId("Health ID already exists");
//            return errorMsg;
//        }
//        else {
        return mCreateService.createTherapistAccount(therapist);
//        }
    }

}
