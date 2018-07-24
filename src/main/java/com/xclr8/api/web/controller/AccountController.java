package com.xclr8.api.web.controller;

import com.xclr8.api.exception.CustomBadRequestException;
import com.xclr8.api.exception.CustomNotFoundException;
import com.xclr8.api.exception.ExceptionMessage;
import com.xclr8.api.service.AccountService;
import com.xclr8.api.service.CreateService;
import com.xclr8.api.web.request.AccountPatientRequest;
import com.xclr8.api.web.request.AccountTherapistRequest;
import com.xclr8.api.web.response.AccountPatientResponse;
import com.xclr8.api.web.response.AccountResponse;
import com.xclr8.api.web.response.AccountTherapistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService mAccountService;
    @Autowired
    CreateService mCreateService;

    ExceptionMessage mExceptionMessage;

    /**
     * GET [url]:8080/account
     * Return all available accounts from database
     * @return Iterable<AccountResponse>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<AccountResponse> accounts() {
        Iterable<AccountResponse> accounts = mAccountService.findAllAccounts();
        if(!accounts.iterator().hasNext())
            throw new CustomNotFoundException(mExceptionMessage.EMPTY.getMsg());
        return accounts;
    }

    /**
     * GET [url]:8080/account/[health Id]
     * Return all available accounts filtered by health Id from database
     * @return Iterable<AccountResponse>
     */
    @RequestMapping(value = "/{healthId}", method = RequestMethod.GET)
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
     * POST [url]:8080/account/create/patient
     * Creates a patient, account, patient statistics object in the database and updates patient group for the related therapist accordingly
     * @param patient
     * @return AccountPatientResponse
     */
    @RequestMapping(value = "/create/patient", method = RequestMethod.POST)
    public AccountPatientResponse createPatient(AccountPatientRequest patient) {
        if((patient.getEmail() == null) || (patient.getPassword() == null) || (patient.getFirstName() == null)
                || (patient.getLastName() == null) || (patient.getMobileNo() == null))
            throw new CustomBadRequestException(mExceptionMessage.REQUEST_BODY_ERROR.getMsg());
        return mCreateService.createPatientAccount(patient);
    }

    /**
     * POST [url]:8080/account/create/therapist
     * Creates a therapist and a patient group object in the database
     * @param therapist
     * @return AccountTherapistResponse
     */
    @RequestMapping(value = "/create/therapist", method = RequestMethod.POST)
    public AccountTherapistResponse createTherapist(@RequestBody AccountTherapistRequest therapist) {
        return mCreateService.createTherapistAccount(therapist);
    }

    /**
     * DELETE [url]:8080/account/[health Id]
     * Remove an account with the given health id from database
     * @param hid
     * @return true
     */
    @RequestMapping(value = "/{hid}", method = RequestMethod.DELETE)
    public boolean deleteByHealthId(@PathVariable String hid) {
        return mAccountService.deleteAccByHealthId(hid);
    }
}
