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

    public static SessionResponse toSessionResponse(Session s){
        SessionResponse sr = new SessionResponse();
        sr.setPatientId(s.getPatientId());
        sr.setTherapistId(s.getTherapistId());
        sr.setTimestamp(s.getTimestamp());
        sr.setSessionGroupId(s.getSessionGroupId());
        sr.setSessionSummary(s.getSessionSummary());
        sr.setExercises(s.getExercises());
        sr.setReplayPath(s.getReplayPath());
        sr.setNotes(s.getNotes());

        return sr;
    }
}
