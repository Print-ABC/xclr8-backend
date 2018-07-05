package com.xclr8.api.web.controller;

import com.xclr8.api.service.PatientGroupService;
import com.xclr8.api.web.response.PatientGroupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patientGroup")
public class PatientGroupController {

    @Autowired
    PatientGroupService mPatientGroupService;

    /**
     * GET [url]:8080/patientGroup/all
     * Return all available patient groups from database
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<PatientGroupResponse> patientGroups() {
        return mPatientGroupService.findAllPatientGroups();
    }
}