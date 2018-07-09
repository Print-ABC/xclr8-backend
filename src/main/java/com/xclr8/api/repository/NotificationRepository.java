package com.xclr8.api.repository;

import com.xclr8.api.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findByHealthId(String healthId);

    @Override
    void deleteById(String s);

    void deleteByHealthId(String healthId);
}
