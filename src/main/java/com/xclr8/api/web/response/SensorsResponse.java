package com.xclr8.api.web.response;

import com.xclr8.api.model.Sensors;
import com.xclr8.api.model.nestedModel.Sensor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SensorsResponse {
    String patientId;
    List<Sensor> sensors;

    /**
     * Create a SensorsResponse from a Sensors object and return it
     * @param sensors
     * @return SensorsResponse
     */
    public SensorsResponse sensorsResponse(Sensors sensors) {
        SensorsResponse sensorsResponse = new SensorsResponse();
        sensorsResponse.setPatientId(sensors.getPatientId());
        sensorsResponse.setSensors(sensors.getSensors());
        return sensorsResponse;
    }

    /**
     * Create a list of SensorsResponse from Sensors objects and return it
     * @param sensors
     * @return sensorsResponses
     */
    public Iterable<SensorsResponse> sensorsResponseIterable(Iterable<Sensors> sensors) {
        ArrayList<SensorsResponse> sensorsResponses = new ArrayList<SensorsResponse>();
        for (Sensors s : sensors) {
            SensorsResponse sensorsResponse = new SensorsResponse();
            sensorsResponse.setPatientId(s.getPatientId());
            sensorsResponse.setSensors(s.getSensors());
            sensorsResponses.add(sensorsResponse);
        }
        return sensorsResponses;
    }
}
