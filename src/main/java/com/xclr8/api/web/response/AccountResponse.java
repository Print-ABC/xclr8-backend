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


    public static Iterable<AccountResponse> toAllAccountResponse(Iterable<Account> aList){
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
