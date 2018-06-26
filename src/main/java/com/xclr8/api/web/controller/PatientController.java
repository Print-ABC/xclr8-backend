package com.xclr8.api.web.controller;

import com.xclr8.api.service.PatientService;
import com.xclr8.api.web.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService mPatientService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<PatientResponse> patients() {
        return mPatientService.findAllPatients();
    }
}
