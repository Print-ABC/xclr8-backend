package com.xclr8.api.web.response;

import com.xclr8.api.model.Diagnosis;
import com.xclr8.api.nestedModel.Note;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DiagnosisResponse {
    String id;
    String patientId;
    String subjective;
    String objective;
    String assessment;
    String plan;
    String diagnosisDate;
    int status;
    List<Note> notes;
    double complianceThreshold;

    /**
     * Create an DiagnosisResponse from an Diagnosis object and return it
     * @param diagnosis
     * @return diagnosisResponse
     */
    public DiagnosisResponse diagnosisResponse(Diagnosis diagnosis){
        DiagnosisResponse diagnosisResponse = new DiagnosisResponse();
        diagnosisResponse.setId(diagnosis.getId());
        diagnosisResponse.setPatientId(diagnosis.getPatientId());
        diagnosisResponse.setSubjective(diagnosis.getSubjective());
        diagnosisResponse.setObjective(diagnosis.getObjective());
        diagnosisResponse.setAssessment(diagnosis.getAssessment());
        diagnosisResponse.setPlan(diagnosis.getPlan());
        diagnosisResponse.setDiagnosisDate(diagnosis.getDiagnosisDate());
        diagnosisResponse.setStatus(diagnosis.getStatus());
        diagnosisResponse.setNotes(diagnosis.getNotes());
        diagnosisResponse.setComplianceThreshold(diagnosis.getComplianceThreshold());
        return diagnosisResponse;
    }

    /**
     * Create a list of DiagnosisResponse from Diagnosis objects and return it
     * @param diagnoses
     * @return diagnosisResponses
     */
    public Iterable<DiagnosisResponse> diagnosisResponseIterable(List<Diagnosis> diagnoses) {
        ArrayList<DiagnosisResponse> diagnosisResponses = new ArrayList<DiagnosisResponse>();
        for (Diagnosis d : diagnoses) {
            DiagnosisResponse diagnosisResponse = new DiagnosisResponse();
            diagnosisResponse.setId(d.getId());
            diagnosisResponse.setPatientId(d.getPatientId());
            diagnosisResponse.setSubjective(d.getSubjective());
            diagnosisResponse.setObjective(d.getObjective());
            diagnosisResponse.setAssessment(d.getAssessment());
            diagnosisResponse.setPlan(d.getPlan());
            diagnosisResponse.setDiagnosisDate(d.getDiagnosisDate());
            diagnosisResponse.setStatus(d.getStatus());
            diagnosisResponse.setNotes(d.getNotes());
            diagnosisResponse.setComplianceThreshold(d.getComplianceThreshold());
            diagnosisResponses.add(diagnosisResponse);
        }
        return diagnosisResponses;
    }
}
