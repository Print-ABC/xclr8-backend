package com.xclr8.api.web.controller;

import com.xclr8.api.service.DiagnosisService;
import com.xclr8.api.web.request.DiagnosisRequest;
import com.xclr8.api.web.response.DiagnosisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    // GET [url]:8080/diagnosis/id/{id}
    // GET [url]:8080/diagnosis/patient/{id}

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
