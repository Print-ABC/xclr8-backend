package com.xclr8.api.repository;

import com.xclr8.api.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {

    Patient findByHealthId(String healthId);

    List<Patient> findByFirstName(String firstName);

    List<Patient> findByLastName(String lastName);

    List<Patient> findByStreetBuildingName(String streetBuildingName);

    List<Patient> findByPostalCode(int postalCode);

    List<Patient> findByCity(String city);

    List<Patient> findByCountry(String country);

    void deleteByHealthId(String healthId);
}


