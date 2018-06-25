package com.xclr8.api.repository;

import com.xclr8.api.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotifcationRepository extends MongoRepository<Notification, String> {
}
