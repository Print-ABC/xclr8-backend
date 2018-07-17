package com.xclr8.api.web.controller;

import com.xclr8.api.service.PatientStatisticsService;
import com.xclr8.api.web.request.PatientStatisticsRequest;
import com.xclr8.api.web.response.PatientStatisticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient-statistics")
public class PatientStatisticsController {

    @Autowired
    PatientStatisticsService mPatientStatisticsService;

    /**
     * GET [url]:8080/patient-statistics
     * Return all available patient statistics from database
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<PatientStatisticsResponse> patientStatistics() {
        return mPatientStatisticsService.findAllPatientStatistics();
    }

    /**
     * GET [url]:8080/patient-statistics/patient/[patient health id]
     * Return patient statistics with given patient health id from database
     * @param pid
     * @return PatientStatisticsResponse
     */
    @RequestMapping(value = "/patient/{pid}", method = RequestMethod.GET)
    public PatientStatisticsResponse patientStatisticsByPatientId(@PathVariable String pid) {
        return mPatientStatisticsService.findPatientStatisticsByPatientId(pid);
    }

    /**
     * GET [url]:8080/patient-statistics/non-compliant
     * Return all non-compliant patient statistics from database
     * @return Iterable<PatientStatisticsResponse>
     */
    // compliance status
    @RequestMapping(value = "/non-compliant", method = RequestMethod.GET)
    public Iterable<PatientStatisticsResponse> patientStatisticsByNonCompliance() {
        return mPatientStatisticsService.findPatientStatisticsByComplianceStatus(0);
    }

    /**
     * GET [url]:8080/patient-statistics/compliant
     * Return all compliant patient statistics from database
     * @return Iterable<PatientStatisticsResponse>
     */
    @RequestMapping(value = "/compliant", method = RequestMethod.GET)
    public Iterable<PatientStatisticsResponse> patientStatisticsByCompliance() {
        return mPatientStatisticsService.findPatientStatisticsByComplianceStatus(1);
    }

    /**
     * DELETE [url]:8080/patient-statistics/[patient health id]
     * Remove patient statistics with given patient health id from database
     * @param phid
     * @return true
     */
    @RequestMapping(value = "/{phid}", method = RequestMethod.DELETE)
    public boolean deletePatientStatisticsByPatientId(@PathVariable String phid) {
        return mPatientStatisticsService.deletePatientStatisticsByPatientId(phid);
    }

    /**
     * PUT [url]:8080/patient-statistics
     * Edits patient statistics with given patient statistics object into database
     * @param psr
     * @return PatientStatisticsResponse
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public PatientStatisticsResponse editPatientStatistics(@RequestBody PatientStatisticsRequest psr) {
        return mPatientStatisticsService.editPatientStatistics(psr);
    }
}
