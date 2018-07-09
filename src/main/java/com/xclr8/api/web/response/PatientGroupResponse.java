package com.xclr8.api.web.response;

import com.xclr8.api.model.PatientGroup;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PatientGroupResponse {
    String healthId;
    List<String> patientIdList;

    /**
     * Create a PatientGroupResponse from a PatientGroup object and return it
     * @param patientGroup
     * @return patientGroupResponse
     */
    public PatientGroupResponse patientGroupResponse(PatientGroup patientGroup) {
        PatientGroupResponse patientGroupResponse = new PatientGroupResponse();
        patientGroupResponse.setHealthId(patientGroup.getHealthId());
        patientGroupResponse.setPatientIdList(patientGroup.getPatientIdList());
        return patientGroupResponse;
    }

    /**
     * Create a list of PatientGroupResponse from PatientGroup objects and return it
     * @param patientGroups
     * @return patientGroupResponses
     */
    public Iterable<PatientGroupResponse> patientGroupResponseIterable(Iterable<PatientGroup> patientGroups) {
        ArrayList<PatientGroupResponse> patientGroupResponses = new ArrayList<PatientGroupResponse>();
        for (PatientGroup pg : patientGroups) {
            PatientGroupResponse patientGroupResponse = new PatientGroupResponse();
            patientGroupResponse.setHealthId(pg.getHealthId());
            patientGroupResponse.setPatientIdList(pg.getPatientIdList());
            patientGroupResponses.add(patientGroupResponse);
        }
        return patientGroupResponses;
    }
}
