package com.xclr8.api.web.response;

import com.xclr8.api.model.Session;
import com.xclr8.api.model.nestedModel.Exercise;
import com.xclr8.api.model.nestedModel.Summary;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SessionExerciseResponse {
    String id;
    List<Exercise> exercises;

    /**
     * Create an SessionResponse from an Session object and return it
     * @param session
     * @return sessionResponse
     */
    public SessionExerciseResponse sessionResponse(Session session){
        SessionExerciseResponse sessionResponse = new SessionExerciseResponse();
        sessionResponse.setId(session.getId());
        sessionResponse.setExercises(session.getExercises());
        return sessionResponse;
    }
}
