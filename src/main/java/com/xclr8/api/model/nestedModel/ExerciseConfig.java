package com.xclr8.api.model.nestedModel;

import lombok.Data;

@Data
public class ExerciseConfig {
    /**
     ExerciseConfig objects to be stored in the Exercise objects that are to be stored in the Session objects in the database
     */

    String sides;
    int reps;
    int sets;
    int frequency;
    double minAngle;
    double maxAngle;
    double sensitivity;
}
