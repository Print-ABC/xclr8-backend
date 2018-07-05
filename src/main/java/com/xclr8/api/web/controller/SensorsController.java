package com.xclr8.api.web.controller;

import com.xclr8.api.service.SensorsService;
import com.xclr8.api.web.response.SensorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    @Autowired
    SensorsService mSensorsService;

    /**
     * GET [url]:8080/sensors/all
     * Return information of all available sensors from database
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<SensorsResponse> sensors() {
        return mSensorsService.findAllSensors();
    }

    /**
     * GET [url]:8080/sensors/p/[patient health Id]
     * Return all sensors information associated with the given patient health id from database
     * @param phid
     * @return SensorsResponse
     */
    @RequestMapping(value = "/p/{phid}", method = RequestMethod.GET)
    public SensorsResponse sensorsByPatientHealthId(@PathVariable String phid) {
        return mSensorsService.findSensorsByPatientHealthId(phid);
    }
}
