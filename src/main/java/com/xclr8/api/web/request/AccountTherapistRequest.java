package com.xclr8.api.web.request;

import lombok.Data;

@Data
public class AccountTherapistRequest {
    private String password;
    private int accountType = 2;
    private String healthId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
}
