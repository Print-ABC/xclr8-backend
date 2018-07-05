package com.xclr8.api.service;

import com.xclr8.api.model.Sensors;
import com.xclr8.api.repository.SensorsRepository;
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
}
