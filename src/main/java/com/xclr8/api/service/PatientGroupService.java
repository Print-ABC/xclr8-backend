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
}
