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

    public ExerciseDefaultResponse createDefaultExercise(ExerciseDefaultRequest edr){
        Exercise_default ed = new Exercise_default();
        ed.setExerciseName(edr.getExerciseName());
        ed.setDefaultSides(edr.getDefaultSides());
        ed.setDefaultSets(edr.getDefaultSets());
        ed.setDefaultSensitivity(edr.getDefaultSensitivity());
        ed.setDefaultReps(edr.getDefaultReps());
        ed.setDefaultMinAngle(edr.getDefaultMinAngle());
        ed.setDefaultMaxAngle(edr.getDefaultMaxAngle());
        ed.setDefaultFrequency(edr.getDefaultFrequency());
        ed.setBodyPart(edr.getBodyPart());

        ed = mExerciseDefaultRepository.save(ed);

        return ExerciseDefaultResponse.toExerciseDefaultResponse(ed);
    }
}
