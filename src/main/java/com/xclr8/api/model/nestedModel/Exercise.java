package com.xclr8.api.model.nestedModel;

import lombok.Data;

import java.util.List;

@Data
public class Exercise {
    /**
     Exercise object to be stored in the Session objects in the database
     */

    String exerciseId;
    String exerciseName;
    ExerciseConfig config;
    ExerciseResult result;
    List<String> bodyPart;
    //0 = Not completed, 1 = Completed.
    int status;
}
