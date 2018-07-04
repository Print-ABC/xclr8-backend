package com.xclr8.api.service;

import com.xclr8.api.model.Diagnosis;
import com.xclr8.api.repository.DiagnosisRepository;
import com.xclr8.api.web.request.DiagnosisRequest;
import com.xclr8.api.web.response.DiagnosisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisService {

    @Autowired
    DiagnosisRepository mDiagnosisRepository;

    /**
     * Return all available diagnoses from database
     * @return Iterable<DiagnosisResponse>
     */
    public Iterable<DiagnosisResponse> findAllDiagnoses() {
        List<Diagnosis> diagnosisList = mDiagnosisRepository.findAll();
        return new DiagnosisResponse().diagnosisResponseIterable(diagnosisList);
    }

    /**
     * Create and save ...
     * @param diagnosisRequest
     * @return DiagnosisResponse object
     */
    public DiagnosisResponse createDiagnosis(DiagnosisRequest diagnosisRequest){
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setAssessment(diagnosisRequest.getAssessment());
        diagnosis.setComplianceThreshold(diagnosisRequest.getComplianceThreshold());
        diagnosis.setSubjective(diagnosisRequest.getSubjective());
        diagnosis.setStatus(diagnosisRequest.getStatus());
        diagnosis.setPatientId(diagnosisRequest.getPatientId());
        diagnosis.setObjective(diagnosisRequest.getObjective());
        diagnosis.setNotes(diagnosisRequest.getNotes());
        diagnosis.setPlan(diagnosisRequest.getPlan());
        diagnosis.setDiagnosisDate(diagnosisRequest.getDiagnosisDate());

        diagnosis = mDiagnosisRepository.save(diagnosis);

        return new DiagnosisResponse().diagnosisResponse(diagnosis);
    }
}
