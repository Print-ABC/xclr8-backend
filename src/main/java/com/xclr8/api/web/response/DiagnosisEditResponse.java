package com.xclr8.api.web.response;

import com.xclr8.api.model.Diagnosis;
import com.xclr8.api.model.nestedModel.Note;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DiagnosisEditResponse {
    String id;
    String patientId;
    String subjective;
    String objective;
    String assessment;
    String plan;
    String diagnosisDate;
    int status;
    double complianceThreshold;

    /**
     * Create an DiagnosisEditResponse from an Diagnosis object and return it
     * @param diagnosis
     * @return diagnosisEditResponse
     */
    public DiagnosisEditResponse diagnosisEditResponse(Diagnosis diagnosis){
        DiagnosisEditResponse diagnosisResponse = new DiagnosisEditResponse();
        diagnosisResponse.setId(diagnosis.getId());
        diagnosisResponse.setPatientId(diagnosis.getPatientId());
        diagnosisResponse.setSubjective(diagnosis.getSubjective());
        diagnosisResponse.setObjective(diagnosis.getObjective());
        diagnosisResponse.setAssessment(diagnosis.getAssessment());
        diagnosisResponse.setPlan(diagnosis.getPlan());
        diagnosisResponse.setDiagnosisDate(diagnosis.getDiagnosisDate());
        diagnosisResponse.setStatus(diagnosis.getStatus());
        diagnosisResponse.setComplianceThreshold(diagnosis.getComplianceThreshold());
        return diagnosisResponse;
    }
}
