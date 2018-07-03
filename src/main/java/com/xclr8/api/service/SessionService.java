package com.xclr8.api.service;

import com.xclr8.api.model.Session;
import com.xclr8.api.repository.SessionRepository;
import com.xclr8.api.web.request.SessionRequest;
import com.xclr8.api.web.response.SessionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    SessionRepository mSessionRespository;

    public SessionResponse createSession(SessionRequest sr){
        Session s = new Session();
        s.setPatientId(sr.getPatientId());
        s.setTherapistId(sr.getTherapistId());
        s.setTimestamp(sr.getTimestamp());
        s.setSessionGroupId(sr.getSessionGroupId());
        s.setSessionSummary(sr.getSessionSummary());
        s.setExercises(sr.getExercises());
        s.setReplayPath(sr.getReplayPath());
        s.setNotes(sr.getNotes());

        return SessionResponse.toSessionResponse(s);
    }
}
