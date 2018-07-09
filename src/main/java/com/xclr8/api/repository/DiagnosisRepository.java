package com.xclr8.api.repository;

import com.xclr8.api.model.Diagnosis;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DiagnosisRepository extends MongoRepository<Diagnosis, String> {

    List<Diagnosis> findByPatientId(String patientId);

    List<Diagnosis> findByStatus(int status);

    List<Diagnosis> findByPatientIdAndStatus(String patientId, int status);

    void deleteByPatientId(String patientId);
}
