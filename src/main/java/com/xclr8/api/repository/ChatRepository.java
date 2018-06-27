package com.xclr8.api.repository;

import com.xclr8.api.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Chat, String> {

    List<Chat> findByTherapistHealthId(String therapist_healthId);

    List<Chat> findByPatientHealthId(String patient_healthId);
}
