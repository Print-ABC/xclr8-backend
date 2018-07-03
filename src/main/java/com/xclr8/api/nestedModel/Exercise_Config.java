package com.xclr8.api.nestedModel;

import lombok.Data;

@Data
public class Exercise_Config {
    /**
     Exercise_Config objects to be stored in the Exercise objects that are to be stored in the Session objects in the database
     */

    String sides;
    int reps;
    int sets;
    int frequency;
    double minAngle;
    double maxAngle;
    double sensitivity;
}
