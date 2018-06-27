package com.xclr8.api.repository;

import com.xclr8.api.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findByHealthId(String healthId);
}
