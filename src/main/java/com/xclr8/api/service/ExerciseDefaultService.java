package com.xclr8.api.service;

import com.xclr8.api.model.ExerciseDefault;
import com.xclr8.api.repository.ExerciseDefaultRepository;
import com.xclr8.api.web.request.ExerciseDefaultRequest;
import com.xclr8.api.web.response.ExerciseDefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseDefaultService {
    @Autowired
    ExerciseDefaultRepository mExerciseDefaultRepository;

    /**
     * Return all available default exercises from database
     * @return
     */
    public Iterable<ExerciseDefaultResponse> findAllExerciseDefaults() {
        List<ExerciseDefault> exerciseDefaultList = mExerciseDefaultRepository.findAll();
        return new ExerciseDefaultResponse().exerciseDefaultResponseIterable(exerciseDefaultList);
    }

    /**
     * Create and save ...
     * @param exerciseDefaultRequest
     * @return ExerciseDefaultResponse object
     */
    public ExerciseDefaultResponse createDefaultExercise(ExerciseDefaultRequest exerciseDefaultRequest){
        ExerciseDefault exerciseDefault = new ExerciseDefault();
        exerciseDefault.setExerciseName(exerciseDefaultRequest.getExerciseName());
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

    /**
     * Remove a exercise by its document id from database
     * @param id
     * @return true
     */
    public boolean deleteExerciseById(String id) {
        mExerciseDefaultRepository.deleteById(id);
        return true;
    }

    /**
     * Remove a exercise by its name from database
     * @param name
     * @return true
     */
    public boolean deleteExerciseByExerciseName(String name) {
        mExerciseDefaultRepository.deleteByExerciseName(name);
        return true;
    }
}
