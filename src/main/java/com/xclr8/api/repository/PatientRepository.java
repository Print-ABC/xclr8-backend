package com.xclr8.api.repository;

import com.xclr8.api.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {

    Patient findByHealthId(String healthId);

    List<Patient> findByFirstName(String firstName);

    List<Patient> findByLastName(String lastName);

    void deleteByHealthId(String healthId);
}


