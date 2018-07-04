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
     *
     * @return
     */
    public Iterable<SensorsResponse> findAllSensors() {
        List<Sensors> sensorsResponseList = mSensorsRepository.findAll();
        return new SensorsResponse().sensorsResponseIterable(sensorsResponseList);
    }
}
