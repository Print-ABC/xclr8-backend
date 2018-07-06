package com.xclr8.api.service;

import com.xclr8.api.model.Session;
import com.xclr8.api.repository.SessionRepository;
import com.xclr8.api.web.request.SessionRequest;
import com.xclr8.api.web.response.SessionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    SessionRepository mSessionRespository;

    /**
     * Return all available sessions from database
     * @return Iterable<SessionResponse>
     */
    public Iterable<SessionResponse> findAllSessions() {
        List<Session> sessionList = mSessionRespository.findAll();
        return new SessionResponse().sessionResponseIterable(sessionList);
    }

    /**
     * Return a session with the matching document id from database
     * @param id
     * @return SessionResponse
     */
    public SessionResponse findSessionById(String id) {
        Optional<Session> session = mSessionRespository.findById(id); // Could not override findById() in SessionRepository.java
        Session s = new Session();
        if(session.isPresent())
            s = session.get();
        return new SessionResponse().sessionResponse(s);
    }

    /**
     * Return all sessions with the given session group id from database
     * @param sessionGroupId
     * @return Iterable<SessionResponse>
     */
    public Iterable<SessionResponse> findSessionsBySessionGroupId(String sessionGroupId) {
        List<Session> sessionList = mSessionRespository.findBySessionGroupId(sessionGroupId);
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

    /**
     * Remove a session with the given document id from database
     * @param id
     * @return true
     */
    public boolean deleteSessionsById(String id) {
        mSessionRespository.deleteById(id);
        return true;
    }

    /**
     * Remove all sessions with the given session group id from database
     * @param sessionGroupId
     * @return true
     */
    public boolean deleteSessionsBySessionGroupId(String sessionGroupId) {
        mSessionRespository.deleteBySessionGroupId(sessionGroupId);
        return true;
    }
}
