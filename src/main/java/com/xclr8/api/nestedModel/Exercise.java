package com.xclr8.api.nestedModel;

import lombok.Data;

@Data
public class Exercise {
    /**
     Exercise object to be stored in the Session objects in the database
     */

    String exerciseId;
    String exerciseName;
    ExerciseConfig config;
    ExerciseResult result;
    String bodyPart;
    //0 = Not completed, 1 = Completed.
    int status;
}
