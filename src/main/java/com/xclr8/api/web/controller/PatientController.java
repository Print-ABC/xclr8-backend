package com.xclr8.api.web.controller;

import com.xclr8.api.model.Patient;
import com.xclr8.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository mPatientRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Patient> patients() {
        return mPatientRepository.findAll();
    }
}
