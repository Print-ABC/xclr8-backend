package com.xclr8.api.web.controller;

import com.xclr8.api.service.PatientGroupService;
import com.xclr8.api.web.response.PatientGroupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
     * @return Iterable<PatientGroupResponse>
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<PatientGroupResponse> patientGroups() {
        return mPatientGroupService.findAllPatientGroups();
    }

    /**
     * GET [url]:8080/patientGroup/hid/[patient health Id]
     * Return a PatientGroup with the given patient health Id from database
     * @param hid
     * @return PatientGroupResponse
     */
    @RequestMapping(value = "/hid/{hid}", method = RequestMethod.GET)
    public PatientGroupResponse patientGroupByPatientHealthId(@PathVariable String hid) {
        return mPatientGroupService.findPatientGroupByPatientHealthId(hid);
    }

    /**
     * DELETE [url]:8080/patientGroup/del/[patient health Id]
     * Remove a PatientGroup with the given patient health Id from database
     * @param hid
     * @return true
     */
    @RequestMapping(value = "/del/{hid}", method = RequestMethod.DELETE)
    public boolean deletePatientGroupByPatientHealthId(@PathVariable String hid) {
        return mPatientGroupService.deletePatientGroupByPatientHealthId(hid);
    }
}
