package com.xclr8.api.repository;

import com.xclr8.api.model.Patient_statistics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientStatisticsRepository extends MongoRepository<Patient_statistics, String> {
}
