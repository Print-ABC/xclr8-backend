package com.xclr8.api.repository;

import com.xclr8.api.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test,String> {

}
