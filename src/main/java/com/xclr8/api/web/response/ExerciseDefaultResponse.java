package com.xclr8.api.web.response;

import com.xclr8.api.model.Exercise_default;
import lombok.Data;

@Data
public class ExerciseDefaultResponse {
    String exerciseName;
    String defaultSides;
    int defaultReps;
    int defaultSets;
    int defaultFrequency;
    double defaultMinAngle;
    double defaultMaxAngle;
    double defaultSensitivity;
    String bodyPart;

    /**
     * Create an ExerciseDefaultResponse from an Exercise_default object and return it
     * @param exerciseDefault
     * @return exerciseDefaultResponse
     */
    public ExerciseDefaultResponse exerciseDefaultResponse(Exercise_default exerciseDefault){
        ExerciseDefaultResponse exerciseDefaultResponse = new ExerciseDefaultResponse();
        exerciseDefaultResponse.setExerciseName(exerciseDefault.getExerciseName());
        exerciseDefaultResponse.setDefaultSides(exerciseDefault.getDefaultSides());
        exerciseDefaultResponse.setDefaultReps(exerciseDefault.getDefaultReps());
        exerciseDefaultResponse.setDefaultSets(exerciseDefault.getDefaultSets());
        exerciseDefaultResponse.setDefaultFrequency(exerciseDefault.getDefaultFrequency());
        exerciseDefaultResponse.setDefaultMinAngle(exerciseDefault.getDefaultMinAngle());
        exerciseDefaultResponse.setDefaultMaxAngle(exerciseDefault.getDefaultMaxAngle());
        exerciseDefaultResponse.setDefaultSensitivity(exerciseDefault.getDefaultSensitivity());
        return exerciseDefaultResponse;
    }
}
