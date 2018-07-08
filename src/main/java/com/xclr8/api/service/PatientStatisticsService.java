package com.xclr8.api.service;

import com.xclr8.api.model.PatientStatistics;
import com.xclr8.api.repository.PatientStatisticsRepository;
import com.xclr8.api.web.request.PatientStatisticsRequest;
import com.xclr8.api.web.response.PatientStatisticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientStatisticsService {

    @Autowired
    PatientStatisticsRepository mPatientStatisticsRepository;

    /**
     * Return all available patient statistics from database
     * @return Iterable<PatientStatisticsResponse>
     */
    public Iterable<PatientStatisticsResponse> findAllPatientStatistics() {
        List<PatientStatistics> patientStatisticsList = mPatientStatisticsRepository.findAll();
        return new PatientStatisticsResponse().patientStatisticsResponseIterable(patientStatisticsList);
    }

    /**
     * Return patient statistics with the given patient health ID from database
     * @param pid
     * @return PatientStatisticsResponse
     */
    public PatientStatisticsResponse findPatientStatisticsByPatientId(String pid) {
        PatientStatistics patientStatistics = mPatientStatisticsRepository.findByPatientId(pid);
        return new PatientStatisticsResponse().patientStatisticsResponse(patientStatistics);
    }

    /**
     * Return all available patient statistics with the given compliance status from database
     * @param status
     * @return PatientStatisticsResponse
     */
    public Iterable<PatientStatisticsResponse> findPatientStatisticsByComplianceStatus(int status) {
        List<PatientStatistics> patientStatisticsList = mPatientStatisticsRepository.findByComplianceStatus(status);
        return new PatientStatisticsResponse().patientStatisticsResponseIterable(patientStatisticsList);
    }

    /**
     * Remove patient statistics with the given patient health ID from database
     * @param pid
     * @return true
     */
    public boolean deletePatientStatisticsByPatientId(String pid) {
        mPatientStatisticsRepository.deleteByPatientId(pid);
        return true;
    }

    /**
     * Edits patient statistics with the given patient health ID into database
     * @param patientStatisticsRequest
     * @return PatientStatisticsResponse
     */
    public PatientStatisticsResponse editPatientStatistics(PatientStatisticsRequest patientStatisticsRequest) {
        PatientStatistics ps = new PatientStatistics();
        Optional<PatientStatistics> check = mPatientStatisticsRepository.findById(patientStatisticsRequest.getId());
        if (check.isPresent()){
            ps = check.get();
            ps.setImprovementROM(patientStatisticsRequest.getImprovementROM());
            ps.setComplianceStatus(patientStatisticsRequest.getComplianceStatus());
            ps.setComplianceRating(patientStatisticsRequest.getComplianceRating());

            mPatientStatisticsRepository.save(ps);
        }


        return new PatientStatisticsResponse().patientStatisticsResponse(ps);
    }
}
