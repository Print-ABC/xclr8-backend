package com.xclr8.api.service;


import com.xclr8.api.model.Account;
import com.xclr8.api.model.Patient;
import com.xclr8.api.repository.AccountRepository;
import com.xclr8.api.repository.PatientRepository;
import com.xclr8.api.web.request.AccountPatientRequest;
import com.xclr8.api.web.response.AccountPatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreationService {
    @Autowired
    AccountRepository mAccountRepository;
    @Autowired
    PatientRepository mPatientRepository;

    public AccountPatientResponse createPatientAccount(AccountPatientRequest accountDetails){
        Account account = new Account();
        Patient patient = new Patient();

        account.setFirstName(accountDetails.getFirstName());
        account.setAccountType(accountDetails.getAccountType());
        account.setEmail(accountDetails.getEmail());
        account.setHealthId(accountDetails.getHealthId());
        account.setLastName(accountDetails.getLastName());
        account.setMobileNo(accountDetails.getMobileNo());
        account.setPassword(accountDetails.getPassword());

        patient.setCity(accountDetails.getCity());
        patient.setCountry(accountDetails.getCountry());
        patient.setDob(accountDetails.getDob());
        patient.setEmail(accountDetails.getEmail());
        patient.setEmergencyNo(accountDetails.getEmergencyNo());
        patient.setFixedLineNo(accountDetails.getFixedLineNo());
        patient.setFirstName(accountDetails.getFirstName());
        patient.setGender(accountDetails.getGender());
        patient.setHealthId(accountDetails.getHealthId());
        patient.setHeight(accountDetails.getHeight());
        patient.setWeight(accountDetails.getWeight());
        patient.setFirstName(accountDetails.getFirstName());
        patient.setLastName(accountDetails.getLastName());
        patient.setStreetAndBuildingName(accountDetails.getStreetAndBuildingName());
        patient.setInsuranceCompany(accountDetails.getInsuranceCompany());
        patient.setInsurancePolicyNo(accountDetails.getInsurancePolicyNo());
        patient.setMobileNo(accountDetails.getMobileNo());
        patient.setPostalCode(accountDetails.getPostalCode());
        patient.setTherapistId(accountDetails.getTherapistId());

        account = mAccountRepository.save(account);

        if(account.getHealthId() != accountDetails.getHealthId()){
            return null;
        }

        patient = mPatientRepository.save(patient);

       return AccountPatientResponse.createCheck(account, patient);
    }
}
