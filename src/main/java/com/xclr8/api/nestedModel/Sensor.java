package com.xclr8.api.nestedModel;

import lombok.Data;

@Data
public class Sensor {
    /**
        Sensor object to be stored in the Sensors in the database
     */

    String bluetoothMAC;
    String bodyPart;
}
