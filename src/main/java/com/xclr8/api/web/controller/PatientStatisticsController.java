package com.xclr8.api.web.controller;

import com.xclr8.api.service.PatientStatisticsService;
import com.xclr8.api.web.response.PatientStatisticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
}
