package com.xclr8.api.repository;

import com.xclr8.api.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {

    Patient findByHealthId(String healthId);

    @Query("{$or : [ {'firstName': { $regex: ?0, $options:'is'}}, {'lastName': { $regex: ?0, $options:'is'}} ] }")
    List<Patient> findPatientByName(String nameRegex);

    @Query("{'firstName': { $regex: ?0, $options:'is'}}")
    List<Patient> findPatientByFirstName(String firstNameRegex);

    @Query("{'lastName': { $regex: ?0, $options:'is'}}")
    List<Patient> findPatientByLastName(String lastNameRegex);

    @Query("{$or : [ {'streetBuildingName': { $regex: ?0, $options:'is'}}, { 'postalCode': { $regex: ?0, $options:'is'}}, {'city': { $regex: ?0, $options:'is'}} , {'country': { $regex: ?0, $options:'is'}} ] }")
    List<Patient> findPatientByLocation(String locationRegex);

    void deleteByHealthId(String healthId);
}


