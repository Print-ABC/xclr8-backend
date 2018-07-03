package com.xclr8.api.repository;

import com.xclr8.api.model.Exercise_default;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseDefaultRepository extends MongoRepository<Exercise_default, String> {
}
