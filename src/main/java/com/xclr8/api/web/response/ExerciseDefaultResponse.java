package com.xclr8.api.web.response;

import com.xclr8.api.model.ExerciseDefault;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
     * Create an ExerciseDefaultResponse from an ExerciseDefault object and return it
     * @param exerciseDefault
     * @return exerciseDefaultResponse
     */
    public ExerciseDefaultResponse exerciseDefaultResponse(ExerciseDefault exerciseDefault){
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

    /**
     * Create a list of ExerciseDefaultResponse from ExerciseDefault objects and return it
     * @param exerciseDefaults
     * @return exerciseDefaultResponses
     */
    public Iterable<ExerciseDefaultResponse> exerciseDefaultResponseIterable(List<ExerciseDefault> exerciseDefaults) {
        ArrayList<ExerciseDefaultResponse> exerciseDefaultResponses = new ArrayList<ExerciseDefaultResponse>();
        for (ExerciseDefault ed : exerciseDefaults) {
            ExerciseDefaultResponse exerciseDefaultResponse = new ExerciseDefaultResponse();
            exerciseDefaultResponse.setExerciseName(ed.getExerciseName());
            exerciseDefaultResponse.setDefaultSides(ed.getDefaultSides());
            exerciseDefaultResponse.setDefaultReps(ed.getDefaultReps());
            exerciseDefaultResponse.setDefaultSets(ed.getDefaultSets());
            exerciseDefaultResponse.setDefaultFrequency(ed.getDefaultFrequency());
            exerciseDefaultResponse.setDefaultMinAngle(ed.getDefaultMinAngle());
            exerciseDefaultResponse.setDefaultMaxAngle(ed.getDefaultMaxAngle());
            exerciseDefaultResponse.setDefaultSensitivity(ed.getDefaultSensitivity());
            exerciseDefaultResponses.add(exerciseDefaultResponse);
        }
        return exerciseDefaultResponses;
    }
}
