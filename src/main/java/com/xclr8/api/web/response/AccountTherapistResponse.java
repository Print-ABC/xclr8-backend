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
    private int mobileNo;

    public static AccountTherapistResponse toTherapistAccount(Account a){
        AccountTherapistResponse accountTherapistResponse = new AccountTherapistResponse();
        accountTherapistResponse.setPassword(a.getPassword());
        accountTherapistResponse.setAccountType(2);
        accountTherapistResponse.setHealthId(a.getHealthId());
        accountTherapistResponse.setFirstName(a.getFirstName());
        accountTherapistResponse.setLastName(a.getLastName());
        accountTherapistResponse.setEmail(a.getEmail());
        accountTherapistResponse.setMobileNo(a.getMobileNo());

        return accountTherapistResponse;
    }
}
