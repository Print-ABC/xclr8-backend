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

    /**
     * Return a SessionResponse based on the given SessionRequest
     * @param sessionRequest
     * @return
     */
    public SessionResponse createSession(SessionRequest sessionRequest){
        Session session = new Session();
        session.setPatientId(sessionRequest.getPatientId());
        session.setTherapistId(sessionRequest.getTherapistId());
        session.setTimestamp(sessionRequest.getTimestamp());
        session.setSessionGroupId(sessionRequest.getSessionGroupId());
        session.setSessionSummary(sessionRequest.getSessionSummary());
        session.setExercises(sessionRequest.getExercises());
        session.setReplayPath(sessionRequest.getReplayPath());
        session.setNotes(sessionRequest.getNotes());
        return new SessionResponse().sessionResponse(session);
    }
}
