package com.xclr8.api.service;


import com.xclr8.api.model.*;
import com.xclr8.api.model.nestedModel.PatientGroupPatient;
import com.xclr8.api.model.nestedModel.Sensor;
import com.xclr8.api.repository.*;
import com.xclr8.api.web.request.AccountPatientRequest;
import com.xclr8.api.web.request.AccountTherapistRequest;
import com.xclr8.api.web.response.AccountPatientResponse;
import com.xclr8.api.web.response.AccountTherapistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateService {
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
        PatientStatistics patientStats = new PatientStatistics();
        PatientGroup patientGroup = new PatientGroup();
        Sensors sensorSet = new Sensors();

        //Auto generation of health ID
        long tempId = mAccountRepository.countByHealthId("p" + ".*");
        String tempHID = "p" + String.valueOf(tempId + 1);

        account.setFirstName(accountDetails.getFirstName());
        account.setAccountType(accountDetails.getAccountType());
        account.setEmail(accountDetails.getEmail());
        account.setHealthId(tempHID);
        account.setLastName(accountDetails.getLastName());
        account.setMobileNo(accountDetails.getMobileNo());
        account.setPassword(accountDetails.getPassword());

        patient.setCity(accountDetails.getCity());
        patient.setCountry(accountDetails.getCountry());
        patient.setDob(accountDetails.getDob());
        patient.setEmail(accountDetails.getEmail());
        patient.setEmergencyNo(accountDetails.getEmergencyNo());
        patient.setFixedLineNo(accountDetails.getFixedLineNo());
        patient.setGender(accountDetails.getGender());
        patient.setHealthId(tempHID);
        patient.setHeight(accountDetails.getHeight());
        patient.setWeight(accountDetails.getWeight());
        patient.setFirstName(accountDetails.getFirstName());
        patient.setLastName(accountDetails.getLastName());
        patient.setStreetBuildingName(accountDetails.getStreetBuildingName());
        patient.setInsuranceCompany(accountDetails.getInsuranceCompany());
        patient.setInsurancePolicyNo(accountDetails.getInsurancePolicyNo());
        patient.setMobileNo(accountDetails.getMobileNo());
        patient.setPostalCode(accountDetails.getPostalCode());
        patient.setTherapistId(accountDetails.getTherapistId());

        patientStats.setPatientId(tempHID);
        patientStats.setComplianceRating(100);
        patientStats.setComplianceStatus(1);
        patientStats.setImprovementROM(0);

        patientGroup = mPatientGroupRepository.findByHealthId(accountDetails.getTherapistId());
        ArrayList<PatientGroupPatient> patientIdList = new ArrayList<PatientGroupPatient>(patientGroup.getPatientIdList());
        PatientGroupPatient temp = new PatientGroupPatient();
        temp.setHealthId(tempHID);
        temp.setName(accountDetails.getFirstName() + " " + accountDetails.getLastName());
        temp.setNumber(accountDetails.getMobileNo());
        patientIdList.add(temp);
        patientGroup.setPatientIdList(patientIdList);

        sensorSet.setPatientId(tempHID);
        ArrayList<Sensor> sensorList = new ArrayList<>();
        sensorSet.setSensors(sensorList);

        account = mAccountRepository.save(account);

        if(account.getHealthId() != tempHID){
            return null;
        }

        patient = mPatientRepository.save(patient);

        if (patient.getHealthId() != tempHID){
            return null;
        }

        patientStats = mPatientStatisticsRepository.save(patientStats);

        if (patientStats.getPatientId() != tempHID){
            return null;
        }

        patientGroup = mPatientGroupRepository.save(patientGroup);
        sensorSet = mSensorsRepository.save(sensorSet);

       return new AccountPatientResponse().accountPatientResponse(account, patient);
    }

    public AccountTherapistResponse createTherapistAccount(AccountTherapistRequest accountDetails){
        Account account = new Account();
        PatientGroup patientGroup = new PatientGroup();

        //Auto generation of health ID
        long tempId = mAccountRepository.countByHealthId("t" + ".*");
        String tempHID = "t" + String.valueOf(tempId + 1);

        account.setFirstName(accountDetails.getFirstName());
        account.setAccountType(accountDetails.getAccountType());
        account.setEmail(accountDetails.getEmail());
        account.setHealthId(tempHID);
        account.setLastName(accountDetails.getLastName());
        account.setMobileNo(accountDetails.getMobileNo());
        account.setPassword(accountDetails.getPassword());

        patientGroup.setHealthId(tempHID);
        List<PatientGroupPatient> patientIdList = new ArrayList<>();
        patientGroup.setPatientIdList(patientIdList);

        account = mAccountRepository.save(account);

        if (account.getHealthId() != tempHID){
            return null;
        }

        patientGroup = mPatientGroupRepository.save(patientGroup);

        if (patientGroup.getHealthId() != tempHID){
            return null;
        }

        return new AccountTherapistResponse().accountTherapistResponse(account);
    }

    public AccountPatientResponse editPatient(AccountPatientRequest accountDetails){
        Account account = new Account();
        Patient patient = new Patient();


        account = mAccountRepository.findByHealthId(accountDetails.getHealthId());
        if (account == null) {
            //Something went wrong!
        } else {
            account.setHealthId(accountDetails.getHealthId());
            account.setFirstName(accountDetails.getFirstName());
            account.setEmail(accountDetails.getEmail());
            account.setLastName(accountDetails.getLastName());
            account.setMobileNo(accountDetails.getMobileNo());
            account.setPassword(accountDetails.getPassword());
        }

        patient = mPatientRepository.findByHealthId(accountDetails.getHealthId());
        if (patient == null) {
            //Something went wrong!
        } else {
            patient.setHealthId(accountDetails.getHealthId());
            patient.setCity(accountDetails.getCity());
            patient.setCountry(accountDetails.getCountry());
            patient.setDob(accountDetails.getDob());
            patient.setEmail(accountDetails.getEmail());
            patient.setEmergencyNo(accountDetails.getEmergencyNo());
            patient.setFixedLineNo(accountDetails.getFixedLineNo());
            patient.setGender(accountDetails.getGender());
            patient.setHeight(accountDetails.getHeight());
            patient.setWeight(accountDetails.getWeight());
            patient.setFirstName(accountDetails.getFirstName());
            patient.setLastName(accountDetails.getLastName());
            patient.setStreetBuildingName(accountDetails.getStreetBuildingName());
            patient.setInsuranceCompany(accountDetails.getInsuranceCompany());
            patient.setInsurancePolicyNo(accountDetails.getInsurancePolicyNo());
            patient.setMobileNo(accountDetails.getMobileNo());
            patient.setPostalCode(accountDetails.getPostalCode());
        }


        account = mAccountRepository.save(account);

        if(account.getHealthId() != accountDetails.getHealthId()){
            return null;
        }

        patient = mPatientRepository.save(patient);

        if (patient.getHealthId() != accountDetails.getHealthId()){
            return null;
        }

        return new AccountPatientResponse().accountPatientEditResponse(account, patient);
    }

}
