package com.xclr8.api.model.nestedModel;

import lombok.Data;

@Data
public class ExerciseResult {
    /**
     ExerciseResult objects to be stored in the Exercise objects that are to be stored in the Session objects in the database
     */

    int reps;
    double minAngle;
    double maxAngle;
    double speed;
    //Duration saved in seconds
    int duration;
}
