package com.xclr8.api.web.response;

import com.xclr8.api.model.Patient;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PatientResponse {
    private String id;
    private String patient_Id;
    private String firstName;
    private String lastName;

    public static Iterable<PatientResponse> toAllPatientResponse(Iterable<Patient> pList){
        ArrayList<PatientResponse> pRList = new ArrayList<PatientResponse>();
        for (Patient p : pList) {
            PatientResponse pR = new PatientResponse();
            pR.setId(p.getId());
            pR.setPatient_Id(p.getPatient_Id());
            pR.setFirstName(p.getFirstName());
            pR.setLastName(p.getLastName());
            pRList.add(pR);
        }

        return pRList;
    }

}
