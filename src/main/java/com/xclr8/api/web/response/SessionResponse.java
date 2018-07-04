package com.xclr8.api.web.response;

import com.xclr8.api.model.Session;
import com.xclr8.api.nestedModel.Exercise;
import com.xclr8.api.nestedModel.Summary;
import lombok.Data;

import java.util.List;

@Data
public class SessionResponse {
    String patientId;
    String therapistId;
    String timestamp;
    String sessionGroupId;
    Summary sessionSummary;
    List<Exercise> exercises;
    String replayPath;
    String notes;

    /**
     * Create an SessionResponse from an Session object and return it
     * @param session
     * @return sessionResponse
     */
    public SessionResponse sessionResponse(Session session){
        SessionResponse sessionResponse = new SessionResponse();
        sessionResponse.setPatientId(session.getPatientId());
        sessionResponse.setTherapistId(session.getTherapistId());
        sessionResponse.setTimestamp(session.getTimestamp());
        sessionResponse.setSessionGroupId(session.getSessionGroupId());
        sessionResponse.setSessionSummary(session.getSessionSummary());
        sessionResponse.setExercises(session.getExercises());
        sessionResponse.setReplayPath(session.getReplayPath());
        sessionResponse.setNotes(session.getNotes());
        return sessionResponse;
    }
}
