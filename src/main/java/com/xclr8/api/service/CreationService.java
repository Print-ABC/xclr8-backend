package com.xclr8.api.service;


import com.xclr8.api.model.*;
import com.xclr8.api.nestedModel.Sensor;
import com.xclr8.api.repository.*;
import com.xclr8.api.web.request.AccountPatientRequest;
import com.xclr8.api.web.request.AccountTherapistRequest;
import com.xclr8.api.web.response.AccountPatientResponse;
import com.xclr8.api.web.response.AccountTherapistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CreationService {
    @Autowired
    AccountRepository mAccountRepository;
    @Autowired
    PatientRepository mPatientRepository;
    @Autowired
    PatientStatisticsRepository mPatientStatisticsRepository;
    @Autowired
    PatientGroupRepository mPatientGroupRepository;
    @Autowired
    SensorsRepository mSensorsRepository;

    /**
     * ...
     * @param accountDetails
     * @return AccountPatientResponse
     */
    public AccountPatientResponse createPatientAccount(AccountPatientRequest accountDetails){
        Account account = new Account();
        Patient patient = new Patient();
        Patient_statistics patientStats = new Patient_statistics();
        Patient_group patientGroup = new Patient_group();
        Sensors sensorSet = new Sensors();

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

        patientStats.setPatientId(accountDetails.getHealthId());
        patientStats.setComplianceRating(100);
        patientStats.setComplianceStatus(1);
        patientStats.setImprovementROM(0);

        patientGroup = mPatientGroupRepository.findByHealthId(accountDetails.getTherapistId());
        ArrayList<String> patientIdList = new ArrayList<String>(patientGroup.getPatientIdList());
        patientIdList.add(accountDetails.getHealthId());
        patientGroup.setPatientIdList(patientIdList);

        sensorSet.setPatientId(accountDetails.getHealthId());
        ArrayList<Sensor> sensorList = new ArrayList<>();
        sensorSet.setSensors(sensorList);

        account = mAccountRepository.save(account);

        if(account.getHealthId() != accountDetails.getHealthId()){
            return null;
        }

        patient = mPatientRepository.save(patient);

        if (patient.getHealthId() != accountDetails.getHealthId()){
            return null;
        }

        patientStats = mPatientStatisticsRepository.save(patientStats);

        if (patientStats.getPatientId() != accountDetails.getHealthId()){
            return null;
        }

        patientGroup = mPatientGroupRepository.save(patientGroup);
        sensorSet = mSensorsRepository.save(sensorSet);

       return new AccountPatientResponse().accountPatientResponse(account, patient);
    }

    public AccountTherapistResponse createTherapistAccount(AccountTherapistRequest accountDetails){
        Account account = new Account();
        Patient_group patientGroup = new Patient_group();

        account.setFirstName(accountDetails.getFirstName());
        account.setAccountType(accountDetails.getAccountType());
        account.setEmail(accountDetails.getEmail());
        account.setHealthId(accountDetails.getHealthId());
        account.setLastName(accountDetails.getLastName());
        account.setMobileNo(accountDetails.getMobileNo());
        account.setPassword(accountDetails.getPassword());

        patientGroup.setHealthId(accountDetails.getHealthId());
        List<String> patientIdList = new ArrayList<>();
        patientGroup.setPatientIdList(patientIdList);

        account = mAccountRepository.save(account);

        if (account.getHealthId() != accountDetails.getHealthId()){
            return null;
        }

        patientGroup = mPatientGroupRepository.save(patientGroup);

        if (patientGroup.getHealthId() != accountDetails.getHealthId()){
            return null;
        }

        return new AccountTherapistResponse().accountTherapistResponse(account);
    }
}
