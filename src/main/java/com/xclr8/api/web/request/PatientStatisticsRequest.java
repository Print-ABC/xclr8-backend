package com.xclr8.api.web.request;

import lombok.Data;

@Data
public class PatientStatisticsRequest {
    String id;
    String patientId;
    double improvementROM;
    int complianceStatus;
    double complianceRating;
}
