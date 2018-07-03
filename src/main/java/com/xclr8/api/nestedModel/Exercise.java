package com.xclr8.api.nestedModel;

import com.xclr8.api.nestedModel.Exercise_Config;
import com.xclr8.api.nestedModel.Exercise_Result;
import lombok.Data;

@Data
public class Exercise {
    /**
     Exercise object to be stored in the Session objects in the database
     */

    int exerciseId;
    String exerciseName;
    Exercise_Config config;
    Exercise_Result result;
    String bodyPart;
    //0 = Not completed, 1 = Completed.
    int status;
}
