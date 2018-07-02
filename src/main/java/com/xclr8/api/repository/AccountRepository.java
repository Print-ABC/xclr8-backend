package com.xclr8.api.repository;

import com.xclr8.api.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByHealthId(String healthId);

    Account findByEmail(String email);

    @Query(value = "{ 'healthId' : ?0, 'password' : ?1 }")
    Account findByHealthIdAndPassword(String healthId, String password);

    void deleteByHealthId(String healthId);

    /*
    Account findOneByFirstName(String firstName);

    List<Account> findAllByFirstName(String firstName);*/
}
