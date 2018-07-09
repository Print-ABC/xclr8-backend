package com.xclr8.api.web.response;

import com.xclr8.api.model.PatientStatistics;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PatientStatisticsResponse {
    String patientId;
    double improvementROM;
    int complianceStatus;
    double complianceRating;

    /**
     * Create an PatientStatisticsResponse from an PatientStatistics object and return it
     * @param patientStatistics
     * @return patientStatisticsResponse
     */
    public PatientStatisticsResponse patientStatisticsResponse(PatientStatistics patientStatistics) {
        PatientStatisticsResponse patientStatisticsResponse = new PatientStatisticsResponse();
        patientStatisticsResponse.setPatientId(patientStatistics.getPatientId());
        patientStatisticsResponse.setImprovementROM(patientStatistics.getImprovementROM());
        patientStatisticsResponse.setComplianceStatus(patientStatistics.getComplianceStatus());
        patientStatisticsResponse.setComplianceRating(patientStatistics.getComplianceRating());
        return patientStatisticsResponse;
    }

    /**
     * Create a list of PatientStatisticsResponse from PatientStatistics objects and return it
     * @param patientStatistics
     * @return patientStatisticsResponses
     */
    public Iterable<PatientStatisticsResponse> patientStatisticsResponseIterable(Iterable<PatientStatistics> patientStatistics) {
        ArrayList<PatientStatisticsResponse> patientStatisticsResponses = new ArrayList<PatientStatisticsResponse>();
        for (PatientStatistics ps : patientStatistics) {
            PatientStatisticsResponse patientStatisticsResponse = new PatientStatisticsResponse();
            patientStatisticsResponse.setPatientId(ps.getPatientId());
            patientStatisticsResponse.setImprovementROM(ps.getImprovementROM());
            patientStatisticsResponse.setComplianceStatus(ps.getComplianceStatus());
            patientStatisticsResponse.setComplianceRating(ps.getComplianceRating());
            patientStatisticsResponses.add(patientStatisticsResponse);
        }
        return patientStatisticsResponses;
    }
}
