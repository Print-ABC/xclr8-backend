package com.xclr8.api.web.controller;

import com.xclr8.api.model.Account;
import com.xclr8.api.repository.AccountRepository;
import com.xclr8.api.service.AccountService;
import com.xclr8.api.web.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService mAccountService;

    /*
    @Autowired
    AccountRepository mAR;*/

    /**
     * GET [url]:8080/account
     * Return all available accounts from database
     * @return Iterable<AccountResponse>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<AccountResponse> accounts() {
        return mAccountService.findAllAccounts();
    }

    /**
     * GET [url]:8080/account/hid/[health Id]
     * Return all available accounts filtered by health Id from database
     * @return Iterable<AccountResponse>
     */
    @RequestMapping(value = "/hid/{healthId}", method = RequestMethod.GET)
    AccountResponse accByHealthId(@PathVariable String healthId) {
        return mAccountService.findAccByHealthId(healthId);
    }

    /**
     * GET [url]:8080/account/email/[email]
     * Return all available accounts filtered by email address from database
     * @return Iterable<AccountResponse>
     */
    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    AccountResponse accByEmail(@PathVariable String email) {
        return mAccountService.findAccByEmail(email);
    }

    /**
     * GET [url]:8080/acc?hid=[health ID]&email=[email]
     * Return all available accounts filtered by email address from database
     * @return Iterable<AccountResponse>
     */
    @RequestMapping(value = "/acc", method = RequestMethod.GET)
    public AccountResponse accByHealthIdAndPassword(String hid, String pw) {
        return mAccountService.findAccByHealthIdAndPassword(hid, pw);
    }

    /*
    // Keep for temporary reference
    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public Account existTest(String name) {
        return mAR.findOneByFirstName(name);
    }
    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public List<Account> existsTest(String name) {
        return mAR.findAllByFirstName(name);
    }*/
}
