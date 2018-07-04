package com.xclr8.api.repository;

import com.xclr8.api.model.ExerciseDefault;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseDefaultRepository extends MongoRepository<ExerciseDefault, String> {
}
