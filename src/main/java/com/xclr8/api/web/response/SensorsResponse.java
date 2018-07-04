package com.xclr8.api.web.response;

import com.xclr8.api.model.Sensors;
import com.xclr8.api.nestedModel.Sensor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SensorsResponse {
    String patientId;
    List<Sensor> sensors;

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
