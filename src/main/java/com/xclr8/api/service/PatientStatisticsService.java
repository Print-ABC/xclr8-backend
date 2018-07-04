package com.xclr8.api.service;

import com.xclr8.api.model.PatientStatistics;
import com.xclr8.api.repository.PatientStatisticsRepository;
import com.xclr8.api.web.response.PatientStatisticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
