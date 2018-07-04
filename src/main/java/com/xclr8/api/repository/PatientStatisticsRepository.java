package com.xclr8.api.repository;

import com.xclr8.api.model.PatientStatistics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientStatisticsRepository extends MongoRepository<PatientStatistics, String> {
}
