package com.xclr8.api.repository;

import com.xclr8.api.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Account findOneByFirstName(String firstName);

    List<Account> findAllByFirstName(String firstName);
}
