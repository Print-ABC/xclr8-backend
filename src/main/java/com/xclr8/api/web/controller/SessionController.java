package com.xclr8.api.web.controller;

import com.xclr8.api.service.SessionService;
import com.xclr8.api.web.request.SessionExerciseRequest;
import com.xclr8.api.web.request.SessionNotesRequest;
import com.xclr8.api.web.request.SessionRequest;
import com.xclr8.api.web.request.SessionSummaryRequest;
import com.xclr8.api.web.response.SessionExerciseResponse;
import com.xclr8.api.web.response.SessionNotesResponse;
import com.xclr8.api.web.response.SessionResponse;
import com.xclr8.api.web.response.SessionSummaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    SessionService mSessionService;

    /**
     * GET [url]:8080/session
     * Return all available sessions from database
     * @return Iterable<SessionResponse>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<SessionResponse> sessions() {
        return mSessionService.findAllSessions();
    }

    /**
     * GET [url]:8080/session/[document id]
     * Return a session with the matching document id from database
     * @param id
     * @return SessionResponse
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SessionResponse sessionById(@PathVariable String id) {
        return mSessionService.findSessionById(id);
    }

    /**
     * GET [url]:8080/session/group/[session group id]
     * Return all sessions with the given session group id from database
     * @param gid
     * @return Iterable<SessionResponse>
     */
    @RequestMapping(value = "/group/{gid}", method = RequestMethod.GET)
    public Iterable<SessionResponse> sessionsBySessionGroupId(@PathVariable String gid) {
        return mSessionService.findSessionsBySessionGroupId(gid);
    }

    /**
     * POST [url]:8080/session
     * Creates a session object in the database
     * @param sessionRequest
     * @return SessionResponse object
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public SessionResponse createSession(@RequestBody SessionRequest sessionRequest) {
        return mSessionService.createSession(sessionRequest);
    }

    /**
     * PUT [url]:8080/session/summary
     * Updates session summary for the selected session in the database
     * @param sessionSummaryRequest
     * @return SensorsResponse
     */
    @RequestMapping(value = "/summary", method = RequestMethod.PUT)
    public SessionSummaryResponse editSessionSummary(@RequestBody SessionSummaryRequest sessionSummaryRequest) {
        return mSessionService.editSessionSummary(sessionSummaryRequest);
    }

    /**
     * PUT [url]:8080/session/exercises
     * Updates session exercises for the selected session in the database
     * @param sessionExerciseRequest
     * @return SessionExerciseResponse
     */
    @RequestMapping(value = "/exercises", method = RequestMethod.PUT)
    public SessionExerciseResponse editSessionExercises(@RequestBody SessionExerciseRequest sessionExerciseRequest) {
        return mSessionService.editSessionExercises(sessionExerciseRequest);
    }

    /**
     * PUT [url]:8080/session/notes
     * Updates session notes for the selected session in the database
     * @param sessionNotesRequest
     * @return SessionNotesResponse
     */
    @RequestMapping(value = "/notes", method = RequestMethod.PUT)
    public SessionNotesResponse editSessionNotes(@RequestBody SessionNotesRequest sessionNotesRequest) {
        return mSessionService.editSessionNotes(sessionNotesRequest);
    }

    /**
     * DELETE [url]:8080/session/id/[document id]
     * Remove a session with the given document id from database
     * @param id
     * @return true
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteById(@PathVariable String id) {
        return mSessionService.deleteSessionsById(id);
    }

    /**
     * DELETE [url]:8080/session/group/[session group id]
     * Remove all sessions with the given session group id from database
     * @param gid
     * @return true
     */
    @RequestMapping(value = "/group/{gid}", method = RequestMethod.DELETE)
    public boolean deleteBySessionGroupId(@PathVariable String gid) {
        return mSessionService.deleteSessionsBySessionGroupId(gid);
    }
}
