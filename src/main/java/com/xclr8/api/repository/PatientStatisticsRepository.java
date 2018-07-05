package com.xclr8.api.repository;

import com.xclr8.api.model.PatientStatistics;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientStatisticsRepository extends MongoRepository<PatientStatistics, String> {

    PatientStatistics findByPatientId(String patientId);

    List<PatientStatistics> findByComplianceStatus(int complianceStatus);
}
