package com.xclr8.api.service;

import com.xclr8.api.model.Account;
import com.xclr8.api.repository.AccountRepository;
import com.xclr8.api.web.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Iterable<AccountResponse> findAllAccounts(){
        List<Account> aList;
        aList = accountRepository.findAll();
        return AccountResponse.toAllAccountResponse(aList);
    }

}
