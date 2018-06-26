package com.xclr8.api.web.controller;

import com.xclr8.api.model.Account;
import com.xclr8.api.repository.AccountRepository;
import com.xclr8.api.service.AccountService;
import com.xclr8.api.web.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService mAccountService;

    @Autowired
    AccountRepository mAR;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<AccountResponse> accounts() {
        return mAccountService.findAllAccounts();
    }


    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public Account existTest(String name) {
        return mAR.findOneByFirstName(name);
    }

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public List<Account> existsTest(String name) {
        return mAR.findAllByFirstName(name);
    }
}
