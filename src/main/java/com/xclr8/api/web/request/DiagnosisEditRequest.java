package com.xclr8.api.web.request;

import com.xclr8.api.model.nestedModel.Note;
import lombok.Data;

import java.util.List;

@Data
public class DiagnosisEditRequest {
    String id;
    String patientId;
    String subjective;
    String objective;
    String assessment;
    String plan;
    String diagnosisDate;
    int status;
    double complianceThreshold;
}
