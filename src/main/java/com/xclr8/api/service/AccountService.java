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
    AccountRepository mAccountRepository;

    /**
     * Return all available accounts from database
     * @return Iterable<AccountResponse>
     */
    public Iterable<AccountResponse> findAllAccounts(){
        List<Account> accountList = mAccountRepository.findAll();
        return new AccountResponse().accountResponseIterable(accountList);
    }

    /**
     * Return an account with the given health ID from database
     * @param hid
     * @return AccountResponse
     */
    public AccountResponse findAccByHealthId(String hid) {
        Account account = mAccountRepository.findByHealthId(hid);
        return new AccountResponse().accountResponse(account);
    }

    /**
     * Return an account with the given email from database
     * @param email
     * @return AccountResponse
     */
    public AccountResponse findAccByEmail(String email) {
        Account account = mAccountRepository.findByEmail(email);
        return new AccountResponse().accountResponse(account);
    }

    /**
     * Delete an account with the given health ID
     * @param hid
     * @return true
     */
    public boolean deleteAccByHealthId(String hid) {
        mAccountRepository.deleteByHealthId(hid);
        return true;
    }
}
