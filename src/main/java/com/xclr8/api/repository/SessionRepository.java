package com.xclr8.api.repository;

import com.xclr8.api.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SessionRepository extends MongoRepository<Session, String> {

    List<Session> findBySessionGroupId(String sessionGroupId);
}
