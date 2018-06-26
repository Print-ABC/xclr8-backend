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
    PatientRepository patientRepository;

    public Iterable<PatientResponse> findAllPatients(){
        List<Patient> pList;
        pList = patientRepository.findAll();
        return PatientResponse.toAllPatientResponse(pList);
    }
}
