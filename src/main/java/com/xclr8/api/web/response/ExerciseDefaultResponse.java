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

    public static ExerciseDefaultResponse toExerciseDefaultResponse(Exercise_default ed){
        ExerciseDefaultResponse edr = new ExerciseDefaultResponse();
        edr.setExerciseName(ed.getExerciseName());
        edr.setDefaultSides(ed.getDefaultSides());
        edr.setDefaultReps(ed.getDefaultReps());
        edr.setDefaultSets(ed.getDefaultSets());
        edr.setDefaultFrequency(ed.getDefaultFrequency());
        edr.setDefaultMinAngle(ed.getDefaultMinAngle());
        edr.setDefaultMaxAngle(ed.getDefaultMaxAngle());
        edr.setDefaultSensitivity(ed.getDefaultSensitivity());

        return edr;
    }
}
