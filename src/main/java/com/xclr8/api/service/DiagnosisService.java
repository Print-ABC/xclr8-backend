package com.xclr8.api.service;

import com.xclr8.api.model.Diagnosis;
import com.xclr8.api.repository.DiagnosisRepository;
import com.xclr8.api.web.request.DiagnosisRequest;
import com.xclr8.api.web.response.DiagnosisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisService {
    @Autowired
    DiagnosisRepository mDiagnosisRepository;

    public DiagnosisResponse createDiagnosis(DiagnosisRequest dr){
        Diagnosis d = new Diagnosis();
        d.setAssessment(dr.getAssessment());
        d.setComplianceThreshold(dr.getComplianceThreshold());
        d.setSubjective(dr.getSubjective());
        d.setStatus(dr.getStatus());
        d.setPatientId(dr.getPatientId());
        d.setObjective(dr.getObjective());
        d.setNotes(dr.getNotes());
        d.setPlan(dr.getPlan());
        d.setDiagnosisDate(dr.getDiagnosisDate());

        d = mDiagnosisRepository.save(d);

        return DiagnosisResponse.toDiagnosisResponse(d);
    }
}
