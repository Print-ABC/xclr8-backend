package com.xclr8.api.web.controller;

import com.xclr8.api.exception.CustomNotFoundException;
import com.xclr8.api.exception.ExceptionMessage;
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

    ExceptionMessage mExceptionMessage;

    /**
     * GET [url]:8080/sensors
     * Return information of all available sensors from database
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<SensorsResponse> sensors() {
        Iterable<SensorsResponse> sensors = mSensorsService.findAllSensors();
        if(!sensors.iterator().hasNext())
            throw new CustomNotFoundException(mExceptionMessage.EMPTY.getMsg());
        return sensors;
    }

    /**
     * GET [url]:8080/sensors/[patient health Id]
     * Return all sensor information associated with the given patient health id from database
     * @param phid
     * @return SensorsResponse
     */
    @RequestMapping(value = "/{phid}", method = RequestMethod.GET)
    public SensorsResponse sensorsByPatientHealthId(@PathVariable String phid) {
        return mSensorsService.findSensorsByPatientHealthId(phid);
    }

    /**
     * PUT [url]:8080/sensors
     * Edits all sensor information associated with the given patient health id from database
     * @param sensorRequest
     * @return SensorsResponse
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public SensorsResponse editSensors(@RequestBody SensorRequest sensorRequest) {
        return mSensorsService.editSensors(sensorRequest);
    }

    /**
     * DELETE [url]:8080/sensors/[patient health Id]
     * Remove all sensor information associated with the given patient health id from database
     * @param phid
     * @return true
     */
    @RequestMapping(value = "/{phid}", method = RequestMethod.DELETE)
    public boolean deleteSensorsByPatientHealthId(@PathVariable String phid) {
        return mSensorsService.deleteSensorsByPatientHealthId(phid);
    }
}
