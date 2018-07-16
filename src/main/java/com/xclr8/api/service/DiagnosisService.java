package com.xclr8.api.service;

import com.xclr8.api.model.Diagnosis;
import com.xclr8.api.model.nestedModel.Note;
import com.xclr8.api.repository.DiagnosisRepository;
import com.xclr8.api.web.request.DiagnosisEditRequest;
import com.xclr8.api.web.request.DiagnosisRequest;
import com.xclr8.api.web.request.NoteRequest;
import com.xclr8.api.web.response.DiagnosisEditResponse;
import com.xclr8.api.web.response.DiagnosisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public DiagnosisResponse findDiagnosisById(String id) {
        Optional<Diagnosis> diagnosis = mDiagnosisRepository.findById(id); // Could not override findById() in DiagnosisRepository.java
        Diagnosis d = new Diagnosis();
        if(diagnosis.isPresent())
            d = diagnosis.get();
        return new DiagnosisResponse().diagnosisResponse(d);
    }

    /**
     * Return all available diagnoses with the given patient health ID from database
     * @param hid
     * @return Iterable<DiagnosisResponse>
     */
    public Iterable<DiagnosisResponse> findDiagnosisByPatientId(String hid) {
        List<Diagnosis> diagnosisList = mDiagnosisRepository.findByPatientId(hid);
        return new DiagnosisResponse().diagnosisResponseIterable(diagnosisList);
    }

    /**
     * Return either active or inactive diagnoses from database
     * @param status
     * @return Iterable<DiagnosisResponse>
     */
    public Iterable<DiagnosisResponse> findDiagnosisByStatus(int status) {
        List<Diagnosis> diagnosisList = mDiagnosisRepository.findByStatus(status);
        return new DiagnosisResponse().diagnosisResponseIterable(diagnosisList);
    }

    /**
     * Return either active or inactive diagnoses filtered by given patient health ID from database
     * @param hid
     * @param status
     * @return Iterable<DiagnosisResponse>
     */
    public Iterable<DiagnosisResponse> findDiagnosisByPatientIdAndStatus(String hid, int status) {
        List<Diagnosis> diagnosisList = mDiagnosisRepository.findByPatientIdAndStatus(hid, status);
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


    /**
     * Edit and save ...
     * @param diagnosisRequest
     * @return DiagnosisEditResponse object
     */
    public DiagnosisEditResponse editDiagnosis(DiagnosisEditRequest diagnosisRequest){
        Diagnosis diagnosis = new Diagnosis();
        Optional<Diagnosis> diagnosisCheck = mDiagnosisRepository.findById(diagnosisRequest.getId());

        if(diagnosisCheck.isPresent()){
            diagnosis = diagnosisCheck.get();
            diagnosis.setAssessment(diagnosisRequest.getAssessment());
            diagnosis.setComplianceThreshold(diagnosisRequest.getComplianceThreshold());
            diagnosis.setSubjective(diagnosisRequest.getSubjective());
            diagnosis.setStatus(diagnosisRequest.getStatus());
            diagnosis.setObjective(diagnosisRequest.getObjective());
            diagnosis.setPlan(diagnosisRequest.getPlan());
            diagnosis.setDiagnosisDate(diagnosisRequest.getDiagnosisDate());

            diagnosis = mDiagnosisRepository.save(diagnosis);
        } else {
            //Return error
        }

        return new DiagnosisEditResponse().diagnosisEditResponse(diagnosis);
    }

    /**
     * Creates a new Note for a Diagnosis object in the database
     * @param noteRequest
     * @return DiagnosisResponse object
     */
    public DiagnosisResponse addNote(NoteRequest noteRequest){
        Diagnosis diagnosis = new Diagnosis();
        Optional<Diagnosis> diagnosisCheck = mDiagnosisRepository.findById(noteRequest.getDiagnosisId());

        if(diagnosisCheck.isPresent()){
            diagnosis = diagnosisCheck.get();

            Note note = new Note();
            note.setNoteId(diagnosis.getNotes().size());
            note.setDate(noteRequest.getDate());
            note.setText(noteRequest.getText());

            diagnosis.getNotes().add(note);
            diagnosis = mDiagnosisRepository.save(diagnosis);
        } else {
            //Return error
        }

        return new DiagnosisResponse().diagnosisResponse(diagnosis);
    }

    /**
     * Edit a Note for a Diagnosis object in the database
     * @param noteRequest
     * @return DiagnosisResponse object
     */
    public DiagnosisResponse editNote(NoteRequest noteRequest){
        Diagnosis diagnosis = new Diagnosis();
        Optional<Diagnosis> diagnosisCheck = mDiagnosisRepository.findById(noteRequest.getDiagnosisId());

        if(diagnosisCheck.isPresent()){
            diagnosis = diagnosisCheck.get();

            Note note =diagnosis.getNotes().get(noteRequest.getNoteId());
            note.setDate(noteRequest.getDate());
            note.setText(noteRequest.getText());


            diagnosis = mDiagnosisRepository.save(diagnosis);
        } else {
            //Return error
        }

        return new DiagnosisResponse().diagnosisResponse(diagnosis);
    }

    /**
     * Remove diagnoses with the given patient health ID from database
     * @param hid
     * @return true
     */
    public boolean deleteDiagnosisByPatientId(String hid) {
        mDiagnosisRepository.deleteByPatientId(hid);
        return true;
    }
}
