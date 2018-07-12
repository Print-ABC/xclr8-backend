package com.xclr8.api.web.request;

import com.xclr8.api.model.nestedModel.Sensor;
import lombok.Data;

import java.util.List;

@Data
public class SensorRequest {
    String patientId;
    List<Sensor> sensors;
}
