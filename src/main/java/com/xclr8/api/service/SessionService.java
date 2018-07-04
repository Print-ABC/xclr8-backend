package com.xclr8.api.service;

import com.xclr8.api.model.Session;
import com.xclr8.api.repository.SessionRepository;
import com.xclr8.api.web.request.SessionRequest;
import com.xclr8.api.web.response.SessionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    SessionRepository mSessionRespository;

    /**
     * Return all available sessions from database
     * @return
     */
    public Iterable<SessionResponse> findAllSessions() {
        List<Session> sessionList = mSessionRespository.findAll();
        return new SessionResponse().sessionResponseIterable(sessionList);
    }

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
