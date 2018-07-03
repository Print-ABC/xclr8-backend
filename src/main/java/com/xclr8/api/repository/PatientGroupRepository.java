package com.xclr8.api.repository;

import com.xclr8.api.model.Patient_group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientGroupRepository extends MongoRepository<Patient_group, String> {
}
