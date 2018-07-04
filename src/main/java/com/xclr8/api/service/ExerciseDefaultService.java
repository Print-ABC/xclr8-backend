package com.xclr8.api.service;

import com.xclr8.api.model.Exercise_default;
import com.xclr8.api.repository.ExerciseDefaultRepository;
import com.xclr8.api.web.request.ExerciseDefaultRequest;
import com.xclr8.api.web.response.ExerciseDefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseDefaultService {
    @Autowired
    ExerciseDefaultRepository mExerciseDefaultRepository;

    /**
     * Create and save ...
     * @param exerciseDefaultRequest
     * @return ExerciseDefaultResponse object
     */
    public ExerciseDefaultResponse createDefaultExercise(ExerciseDefaultRequest exerciseDefaultRequest){
        Exercise_default exerciseDefault = new Exercise_default();
        exerciseDefault.setExerciseName(exerciseDefaultRequest.getExerciseName());
        exerciseDefault.setDefaultSides(exerciseDefaultRequest.getDefaultSides());
        exerciseDefault.setDefaultSets(exerciseDefaultRequest.getDefaultSets());
        exerciseDefault.setDefaultSensitivity(exerciseDefaultRequest.getDefaultSensitivity());
        exerciseDefault.setDefaultReps(exerciseDefaultRequest.getDefaultReps());
        exerciseDefault.setDefaultMinAngle(exerciseDefaultRequest.getDefaultMinAngle());
        exerciseDefault.setDefaultMaxAngle(exerciseDefaultRequest.getDefaultMaxAngle());
        exerciseDefault.setDefaultFrequency(exerciseDefaultRequest.getDefaultFrequency());
        exerciseDefault.setBodyPart(exerciseDefaultRequest.getBodyPart());

        exerciseDefault = mExerciseDefaultRepository.save(exerciseDefault);

        return new ExerciseDefaultResponse().exerciseDefaultResponse(exerciseDefault);
    }
}
