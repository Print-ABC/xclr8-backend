package com.xclr8.api.web.controller;

import com.xclr8.api.model.Account;
import com.xclr8.api.repository.AccountRepository;
import com.xclr8.api.service.AccountService;
import com.xclr8.api.web.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService mAccountService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<AccountResponse> accounts() {
        return mAccountService.findAllAccounts();
    }
}
