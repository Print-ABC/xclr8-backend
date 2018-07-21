package com.xclr8.api.web.request;

import lombok.Data;

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
