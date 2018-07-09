package com.xclr8.api.service;

import com.xclr8.api.model.Sensors;
import com.xclr8.api.repository.SensorsRepository;
import com.xclr8.api.web.request.SensorRequest;
import com.xclr8.api.web.response.SensorsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorsService {

    @Autowired
    SensorsRepository mSensorsRepository;

    /**
     * Return all sensors information from database
     * @return Iterable<SensorsResponse>
     */
    public Iterable<SensorsResponse> findAllSensors() {
        List<Sensors> sensorsResponseList = mSensorsRepository.findAll();
        return new SensorsResponse().sensorsResponseIterable(sensorsResponseList);
    }

    /**
     * Return all sensors information associated with the given patient health id from database
     * @param pid
     * @return SensorsResponse
     */
    public SensorsResponse findSensorsByPatientHealthId(String pid) {
        Sensors sensors = mSensorsRepository.findByPatientId(pid);
        return new SensorsResponse().sensorsResponse(sensors);
    }

    /**
     * Remove all sensors information associated with the given patient health id from database
     * @param pid
     * @return true
     */
    public boolean deleteSensorsByPatientHealthId(String pid) {
        mSensorsRepository.deleteByPatientId(pid);
        return true;
    }

    /**
     * Edits all sensor information associated with the given patient health id from database
     * @param sensorRequest
     * @return SensorsResponse
     */
    public SensorsResponse editSensors(SensorRequest sensorRequest) {
        Sensors sensors = mSensorsRepository.findByPatientId(sensorRequest.getPatientId());
        if (sensors != null){
            sensors.setSensors(sensorRequest.getSensors());
            mSensorsRepository.save(sensors);
        }

        return new SensorsResponse().sensorsResponse(sensors);
    }
}
