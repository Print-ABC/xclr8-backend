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
     * @return aR
     */
    public AccountResponse response(Account account) {
        AccountResponse aR = new AccountResponse();
        aR.setId(account.getId());
        aR.setHealthId(account.getHealthId());
        aR.setEmail(account.getEmail());
        aR.setMobileNo(account.getMobileNo());
        aR.setPassword(account.getPassword());
        aR.setAccountType(account.getAccountType());
        aR.setFirstName(account.getFirstName());
        aR.setLastName(account.getLastName());
        return aR;
    }

    /**
     * Create a list of AccountResponse from Account objects and return it
     * @param aList
     * @return aRList
     */
    public Iterable<AccountResponse> toAllAccountResponse(Iterable<Account> aList){
        ArrayList<AccountResponse> aRList = new ArrayList<AccountResponse>();
        for (Account a : aList) {
            AccountResponse aR = new AccountResponse();
            aR.setId(a.getId());
            aR.setHealthId(a.getHealthId());
            aR.setEmail(a.getEmail());
            aR.setMobileNo(a.getMobileNo());
            aR.setPassword(a.getPassword());
            aR.setAccountType(a.getAccountType());
            aR.setFirstName(a.getFirstName());
            aR.setLastName(a.getLastName());
            aRList.add(aR);
        }

        return aRList;
    }
}
