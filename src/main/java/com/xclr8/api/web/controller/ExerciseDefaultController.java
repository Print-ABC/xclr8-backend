package com.xclr8.api.web.controller;

import com.xclr8.api.exception.CustomNotFoundException;
import com.xclr8.api.exception.ExceptionMessage;
import com.xclr8.api.service.ExerciseDefaultService;
import com.xclr8.api.web.request.ExerciseDefaultRequest;
import com.xclr8.api.web.response.ExerciseDefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercise")
public class ExerciseDefaultController {
    @Autowired
    ExerciseDefaultService mExerciseDefaultService;

    ExceptionMessage mExceptionMessage;

    /**
     * GET [url]:8080/exercise
     * Return all available default exercises from database
     * @return Iterable<ExerciseDefaultResponse>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ExerciseDefaultResponse> exerciseDefaults() {
        Iterable<ExerciseDefaultResponse> exerciseDefaults = mExerciseDefaultService.findAllExerciseDefaults();
        if(!exerciseDefaults.iterator().hasNext())
            throw new CustomNotFoundException(mExceptionMessage.EMPTY.getMsg());
        return exerciseDefaults;
    }

    /**
     * POST [url]:8080/exercise
     * Creates a Default exercise object in the database
     * @param exerciseDefaultRequest
     * @return ExerciseDefaultResponse
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ExerciseDefaultResponse createDiagnosis(@RequestBody ExerciseDefaultRequest exerciseDefaultRequest) {
        return mExerciseDefaultService.createDefaultExercise(exerciseDefaultRequest);
    }

    /**
     * DELETE [url]:8080/exercise/[document Id]
     * Remove a exercise by its document id from database
     * @param id
     * @return true
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteById(@PathVariable String id){
        return mExerciseDefaultService.deleteExerciseById(id);
    }

    /**
     * DELETE [url]:8080/exercise/name/[exercise name]
     * Remove a exercise by its name from database
     * @param name
     * @return true
     */
    @RequestMapping(value = "/name/{name}", method = RequestMethod.DELETE)
    public boolean deleteByExerciseName(@PathVariable String name){
        return mExerciseDefaultService.deleteExerciseByExerciseName(name);
    }
}
