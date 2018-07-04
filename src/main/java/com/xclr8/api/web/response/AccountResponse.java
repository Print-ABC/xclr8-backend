package com.xclr8.api.web.response;

import com.xclr8.api.model.Account;
import lombok.Data;

import java.util.ArrayList;

@Data
public class AccountResponse {
    private String id;
    private String healthId;
    private String email;
    private int mobileNo;
    private String password;
    private int accountType;
    private String firstName;
    private String lastName;

    /**
     * Create an AccountResponse from an Account object and return it
     * @param account
     * @return accountResponse
     */
    public AccountResponse accountResponse(Account account) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setHealthId(account.getHealthId());
        accountResponse.setEmail(account.getEmail());
        accountResponse.setMobileNo(account.getMobileNo());
        accountResponse.setPassword(account.getPassword());
        accountResponse.setAccountType(account.getAccountType());
        accountResponse.setFirstName(account.getFirstName());
        accountResponse.setLastName(account.getLastName());
        return accountResponse;
    }

    /**
     * Create a list of AccountResponse from Account objects and return it
     * @param accounts
     * @return accountResponses
     */
    public Iterable<AccountResponse> accountResponseIterable(Iterable<Account> accounts){
        ArrayList<AccountResponse> accountResponses = new ArrayList<AccountResponse>();
        for (Account a : accounts) {
            AccountResponse accountResponse = new AccountResponse();
            accountResponse.setId(a.getId());
            accountResponse.setHealthId(a.getHealthId());
            accountResponse.setEmail(a.getEmail());
            accountResponse.setMobileNo(a.getMobileNo());
            accountResponse.setPassword(a.getPassword());
            accountResponse.setAccountType(a.getAccountType());
            accountResponse.setFirstName(a.getFirstName());
            accountResponse.setLastName(a.getLastName());
            accountResponses.add(accountResponse);
        }
        return accountResponses;
    }
}
