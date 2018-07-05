package com.xclr8.api.repository;

import com.xclr8.api.model.PatientGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientGroupRepository extends MongoRepository<PatientGroup, String> {

    PatientGroup findByHealthId(String healthId);
}
