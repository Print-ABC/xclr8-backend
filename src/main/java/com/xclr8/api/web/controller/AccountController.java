package com.xclr8.api.web.controller;

import com.xclr8.api.model.Account;
import com.xclr8.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountRepository mAccountRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Account> accounts() {
        return mAccountRepository.findAll();
    }
}
