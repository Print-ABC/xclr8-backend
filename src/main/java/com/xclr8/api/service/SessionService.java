package com.xclr8.api.service;

import com.xclr8.api.model.Session;
import com.xclr8.api.model.nestedModel.Exercise;
import com.xclr8.api.model.nestedModel.ExerciseResult;
import com.xclr8.api.model.nestedModel.Summary;
import com.xclr8.api.repository.SessionRepository;
import com.xclr8.api.web.request.SessionExerciseRequest;
import com.xclr8.api.web.request.SessionNotesRequest;
import com.xclr8.api.web.request.SessionRequest;
import com.xclr8.api.web.request.SessionSummaryRequest;
import com.xclr8.api.web.response.SessionExerciseResponse;
import com.xclr8.api.web.response.SessionNotesResponse;
import com.xclr8.api.web.response.SessionResponse;
import com.xclr8.api.web.response.SessionSummaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
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
        session.setSessionSummary(new Summary());

        ArrayList<Exercise> temp = new ArrayList<>(sessionRequest.getExercises());
        for (Exercise e : temp){
            e.setResult(new ExerciseResult());
        }

        session.setExercises(temp);
        session.setReplayPath(sessionRequest.getReplayPath());
        session.setNotes(sessionRequest.getNotes());

        session = mSessionRespository.save(session);
        return new SessionResponse().sessionResponse(session);
    }

    /**
     * Updates the session summary for the selected session in the database
     * @param sessionRequest
     * @return SessionSummaryResponse
     */
    public SessionSummaryResponse editSessionSummary(@RequestBody SessionSummaryRequest sessionRequest) {
        Session session = new Session();
        Optional<Session> check = mSessionRespository.findById(sessionRequest.getId());
        if(check.isPresent()){
            session = check.get();
            session.setSessionSummary(sessionRequest.getSessionSummary());

            mSessionRespository.save(session);
        }

        return new SessionSummaryResponse().sessionResponse(session) ;
    }

    /**
     * Updates the exercises for the selected session in the database
     * @param sessionRequest
     * @return SessionExerciseResponse
     */
    public SessionExerciseResponse editSessionExercises(@RequestBody SessionExerciseRequest sessionRequest) {
        Session session = new Session();
        Optional<Session> check = mSessionRespository.findById(sessionRequest.getId());
        if(check.isPresent()){
            session = check.get();
            session.setExercises(sessionRequest.getExercises());

            mSessionRespository.save(session);
        }

        return new SessionExerciseResponse().sessionResponse(session) ;
    }

    /**
     * Updates session notes for the selected session in the database
     * @param sessionRequest
     * @return SessionNotesResponse
     */
    public SessionNotesResponse editSessionNotes(@RequestBody SessionNotesRequest sessionRequest) {
        Session session = new Session();
        Optional<Session> check = mSessionRespository.findById(sessionRequest.getId());
        if(check.isPresent()){
            session = check.get();
            session.setNotes(sessionRequest.getNotes());

            mSessionRespository.save(session);
        }

        return new SessionNotesResponse().sessionResponse(session) ;
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
