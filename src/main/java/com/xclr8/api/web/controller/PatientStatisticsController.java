package com.xclr8.api.web.controller;

import com.xclr8.api.service.PatientStatisticsService;
import com.xclr8.api.web.request.PatientStatisticsRequest;
import com.xclr8.api.web.response.PatientStatisticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
public class PatientStatisticsController {

    @Autowired
    PatientStatisticsService mPatientStatisticsService;

    /**
     * GET [url]:8080/stats/all
     * Return all available patient statistics from database
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<PatientStatisticsResponse> patientStatistics() {
        return mPatientStatisticsService.findAllPatientStatistics();
    }

    /**
     * GET [url]:8080/stats/pid/[patient health id]
     * Return patient statistics with given patient health id from database
     * @param pid
     * @return PatientStatisticsResponse
     */
    @RequestMapping(value = "/pid/{pid}", method = RequestMethod.GET)
    public PatientStatisticsResponse patientStatisticsByPatientId(@PathVariable String pid) {
        return mPatientStatisticsService.findPatientStatisticsByPatientId(pid);
    }

    /**
     * GET [url]:8080/stats/nc
     * Return all non-compliant patient statistics from database
     * @return Iterable<PatientStatisticsResponse>
     */
    // compliance status
    @RequestMapping(value = "/nc", method = RequestMethod.GET)
    public Iterable<PatientStatisticsResponse> patientStatisticsByNonCompliance() {
        return mPatientStatisticsService.findPatientStatisticsByComplianceStatus(0);
    }

    /**
     * GET [url]:8080/stats/c
     * Return all compliant patient statistics from database
     * @return Iterable<PatientStatisticsResponse>
     */
    @RequestMapping(value = "/c", method = RequestMethod.GET)
    public Iterable<PatientStatisticsResponse> patientStatisticsByCompliance() {
        return mPatientStatisticsService.findPatientStatisticsByComplianceStatus(1);
    }

    /**
     * DELETE [url]:8080/stats/del/[patient health id]
     * Remove patient statistics with given patient health id from database
     * @param pid
     * @return true
     */
    @RequestMapping(value = "/del/{pid}", method = RequestMethod.DELETE)
    public boolean deletePatientStatisticsByPatientId(@PathVariable String pid) {
        return mPatientStatisticsService.deletePatientStatisticsByPatientId(pid);
    }

    /**
     * PUT [url]:8080/stats/edit/
     * Edits patient statistics with given patient statistics object into database
     * @param psr
     * @return PatientStatisticsResponse
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public PatientStatisticsResponse editPatientStatistics(@RequestBody PatientStatisticsRequest psr) {
        return mPatientStatisticsService.editPatientStatistics(psr);
    }
}
