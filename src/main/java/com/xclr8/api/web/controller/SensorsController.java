package com.xclr8.api.web.controller;

import com.xclr8.api.service.SensorsService;
import com.xclr8.api.web.request.SensorRequest;
import com.xclr8.api.web.response.SensorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * Return all sensor information associated with the given patient health id from database
     * @param phid
     * @return SensorsResponse
     */
    @RequestMapping(value = "/p/{phid}", method = RequestMethod.GET)
    public SensorsResponse sensorsByPatientHealthId(@PathVariable String phid) {
        return mSensorsService.findSensorsByPatientHealthId(phid);
    }

    /**
     * DELETE [url]:8080/sensors/del/[patient health Id]
     * Remove all sensor information associated with the given patient health id from database
     * @param phid
     * @return true
     */
    @RequestMapping(value = "/del/{phid}", method = RequestMethod.DELETE)
    public boolean deleteSensorsByPatientHealthId(@PathVariable String phid) {
        return mSensorsService.deleteSensorsByPatientHealthId(phid);
    }

    /**
     * PUT [url]:8080/sensors/edit/
     * Edits all sensor information associated with the given patient health id from database
     * @param sensorRequest
     * @return SensorsResponse
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public SensorsResponse editSensors(@RequestBody SensorRequest sensorRequest) {
        return mSensorsService.editSensors(sensorRequest);
    }
}
