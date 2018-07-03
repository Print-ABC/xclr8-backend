package com.xclr8.api.repository;

import com.xclr8.api.model.Sensors;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorsRepository extends MongoRepository<Sensors, String> {
}
