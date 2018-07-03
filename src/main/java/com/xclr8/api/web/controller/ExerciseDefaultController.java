package com.xclr8.api.web.controller;

import com.xclr8.api.service.ExerciseDefaultService;
import com.xclr8.api.web.request.ExerciseDefaultRequest;
import com.xclr8.api.web.response.ExerciseDefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exerciseDefault")
public class ExerciseDefaultController {
    @Autowired
    ExerciseDefaultService mExerciseDefaultService;
    /**
     * POST [url]:8080/exerciseDefault/create
     * Creates a Default exercise object in the database
     * @param exerciseDefaultRequest
     * @return ExerciseDefaultResponse
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ExerciseDefaultResponse createDiagnosis(@RequestBody ExerciseDefaultRequest exerciseDefaultRequest) {
        return mExerciseDefaultService.createDefaultExercise(exerciseDefaultRequest);
    }
}
