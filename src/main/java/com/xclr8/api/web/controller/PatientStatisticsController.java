package com.xclr8.api.web.controller;

import com.xclr8.api.service.PatientStatisticsService;
import com.xclr8.api.web.response.PatientStatisticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
