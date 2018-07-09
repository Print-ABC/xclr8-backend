package com.xclr8.api.service;

import com.xclr8.api.model.PatientGroup;
import com.xclr8.api.repository.PatientGroupRepository;
import com.xclr8.api.web.response.PatientGroupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientGroupService {

    @Autowired
    PatientGroupRepository mPatientGroupRepository;

    /**
     * Return all available patient groups from database
     * @return Iterable<PatientGroupResponse>
     */
    public Iterable<PatientGroupResponse> findAllPatientGroups() {
        List<PatientGroup> patientGroupResponseList = mPatientGroupRepository.findAll();
        return new PatientGroupResponse().patientGroupResponseIterable(patientGroupResponseList);
    }

    /**
     * Return a PatientGroup with the given patient health Id from database
     * @param hid
     * @return PatientGroupResponse
     */
    public PatientGroupResponse findPatientGroupByPatientHealthId(String hid) {
        PatientGroup patientGroup = mPatientGroupRepository.findByHealthId(hid);
        return new PatientGroupResponse().patientGroupResponse(patientGroup);
    }

    /**
     * Remove a PatientGroup with the given patient health Id from database
     * @param hid
     * @return true
     */
    public boolean deletePatientGroupByPatientHealthId(String hid) {
        mPatientGroupRepository.deleteByHealthId(hid);
        return true;
    }
}
