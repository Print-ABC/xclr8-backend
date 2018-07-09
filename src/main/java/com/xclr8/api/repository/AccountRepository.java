package com.xclr8.api.repository;

import com.xclr8.api.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByHealthId(String healthId);

    Account findByEmail(String email);

    void deleteByHealthId(String healthId);
}
