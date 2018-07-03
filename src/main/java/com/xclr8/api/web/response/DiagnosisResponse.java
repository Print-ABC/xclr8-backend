package com.xclr8.api.web.response;

import com.xclr8.api.model.Diagnosis;
import com.xclr8.api.nestedModel.Note;
import lombok.Data;

import java.util.List;

@Data
public class DiagnosisResponse {
    String patientId;
    String subjective;
    String objective;
    String assessment;
    String plan;
    String diagnosisDate;
    int status;
    List<Note> notes;
    double complianceThreshold;

    public static DiagnosisResponse toDiagnosisResponse(Diagnosis d){
        DiagnosisResponse dr = new DiagnosisResponse();
        dr.setPatientId(d.getPatientId());
        dr.setSubjective(d.getSubjective());
        dr.setObjective(d.getObjective());
        dr.setAssessment(d.getAssessment());
        dr.setPlan(d.getPlan());
        dr.setDiagnosisDate(d.getDiagnosisDate());
        dr.setStatus(d.getStatus());
        dr.setNotes(d.getNotes());
        dr.setComplianceThreshold(d.getComplianceThreshold());

        return dr;
    }
}
