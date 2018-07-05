package com.xclr8.api.web.controller;

import com.xclr8.api.service.DiagnosisService;
import com.xclr8.api.web.request.DiagnosisRequest;
import com.xclr8.api.web.response.DiagnosisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {

    @Autowired
    DiagnosisService mDiagnosisService;

    /**
     * GET [url]:8080/diagnosis/all
     * Return all available diagnoses from database
     * @return Iterable<DiagnosisResponse>
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<DiagnosisResponse> diagnoses() {
        return mDiagnosisService.findAllDiagnoses();
    }

    /**
     * GET [url]:8080/diagnosis/id/{id}
     * Return all a diagnosis with given document id from database
     * @param id
     * @return
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public DiagnosisResponse diagnosisById(@PathVariable String id) {
        return mDiagnosisService.findDiagnosisById(id);
    }

    /**
     * GET [url]:8080/diagnosis/p/[patient health Id]
     * Return all available diagnoses filtered by patient health Id from database
     * @param hid
     * @return Iterable<DiagnosisResponse>
     */
    @RequestMapping(value = "/p/{hid}", method = RequestMethod.GET)
    public Iterable<DiagnosisResponse> diagnosesByPatientId(@PathVariable String hid) {
        return mDiagnosisService.findDiagnosisByPatientId(hid);
    }

    /**
     * GET [url]:8080/diagnosis/inactive
     * Return all active diagnoses from database
     * @return
     */
    @RequestMapping(value = "/inactive", method = RequestMethod.GET)
    public Iterable<DiagnosisResponse> inactiveDiagnoses() {
        return mDiagnosisService.findDiagnosisByStatus(0);
    }

    /**
     * GET [url]:8080/diagnosis/active
     * Return all active diagnoses from database
     * @return
     */
    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public Iterable<DiagnosisResponse> activeDiagnoses() {
        return mDiagnosisService.findDiagnosisByStatus(1);
    }

    /**
     * GET [url]:8080/diagnosis/p/[patient health Id]/inactive
     * Return all inactive diagnoses filtered by patient health Id from database
     * @param hid
     * @return Iterable<DiagnosisResponse>
     */
    @RequestMapping(value = "/p/{hid}/inactive", method = RequestMethod.GET)
    public Iterable<DiagnosisResponse> inactiveDiagnosesByPatientId(@PathVariable String hid) {
        return mDiagnosisService.findDiagnosisByPatientIdAndStatus(hid, 0);
    }

    /**
     * GET [url]:8080/diagnosis/p/[patient health Id]/active
     * Return all inactive diagnoses filtered by patient health Id from database
     * @param hid
     * @return Iterable<DiagnosisResponse>
     */
    @RequestMapping(value = "/p/{hid}/active", method = RequestMethod.GET)
    public Iterable<DiagnosisResponse> activeDiagnosesByPatientId(@PathVariable String hid) {
        return mDiagnosisService.findDiagnosisByPatientIdAndStatus(hid, 1);
    }

    /**
     * POST [url]:8080/diagnosis/create
     * Creates a diagnosis object in the database
     * @param diagnosisRequest
     * @return DiagnosisResponse
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DiagnosisResponse createDiagnosis(@RequestBody DiagnosisRequest diagnosisRequest) {
        return mDiagnosisService.createDiagnosis(diagnosisRequest);
    }
}
