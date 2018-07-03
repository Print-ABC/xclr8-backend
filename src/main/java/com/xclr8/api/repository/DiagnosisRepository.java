package com.xclr8.api.repository;

import com.xclr8.api.model.Diagnosis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiagnosisRepository extends MongoRepository<Diagnosis, String> {
}
