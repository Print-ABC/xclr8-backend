package com.xclr8.api.web.controller;

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

    /**
     * GET [url]:8080/account/all
     * Return all available accounts from database
     * @return Iterable<AccountResponse>
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
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
     * DELETE [url]:8080/account/del/[health Id]
     * Remove an account with the given health id from database
     * @param hid
     * @return true
     */
    @RequestMapping(value = "/del/{hid}", method = RequestMethod.DELETE)
    public boolean deleteByHealthId(@PathVariable String hid) {
        return mAccountService.deleteAccByHealthId(hid);
    }
}
