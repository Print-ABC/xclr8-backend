package com.xclr8.api.web.request;

import com.xclr8.api.nestedModel.Note;
import lombok.Data;

import java.util.List;

@Data
public class DiagnosisRequest {
    String patientId;
    String subjective;
    String objective;
    String assessment;
    String plan;
    String diagnosisDate;
    int status;
    List<Note> notes;
    double complianceThreshold;
}