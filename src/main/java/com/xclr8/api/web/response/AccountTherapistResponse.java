package com.xclr8.api.web.response;

import com.xclr8.api.model.Account;
import lombok.Data;

@Data
public class AccountTherapistResponse {
    private String password;
    private int accountType = 2;
    private String healthId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;

    /**
     * Create an AccountTherapistResponse from an Account object and return it
     * @param account
     * @return accountTherapistResponse
     */
    public AccountTherapistResponse accountTherapistResponse(Account account){
        AccountTherapistResponse accountTherapistResponse = new AccountTherapistResponse();
        accountTherapistResponse.setPassword(account.getPassword());
        accountTherapistResponse.setAccountType(2);
        accountTherapistResponse.setHealthId(account.getHealthId());
        accountTherapistResponse.setFirstName(account.getFirstName());
        accountTherapistResponse.setLastName(account.getLastName());
        accountTherapistResponse.setEmail(account.getEmail());
        accountTherapistResponse.setMobileNo(account.getMobileNo());
        return accountTherapistResponse;
    }
}
