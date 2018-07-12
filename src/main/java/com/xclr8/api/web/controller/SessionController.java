package com.xclr8.api.web.controller;

import com.xclr8.api.service.SessionService;
import com.xclr8.api.web.request.SessionRequest;
import com.xclr8.api.web.response.SessionResponse;
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
     * GET [url]:8080/session/id/[document id]
     * Return a session with the matching document id from database
     * @param id
     * @return SessionResponse
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public SessionResponse sessionById(@PathVariable String id) {
        return mSessionService.findSessionById(id);
    }

    /**
     * GET [url]:8080/session/gid/[session group id]
     * Return all sessions with the given session group id from database
     * @param gid
     * @return Iterable<SessionResponse>
     */
    @RequestMapping(value = "/gid/{gid}", method = RequestMethod.GET)
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
     * DELETE [url]:8080/session/id/[document id]
     * Remove a session with the given document id from database
     * @param id
     * @return true
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public boolean deleteById(@PathVariable String id) {
        return mSessionService.deleteSessionsById(id);
    }

    /**
     * DELETE [url]:8080/session/gid/[session group id]
     * Remove all sessions with the given session group id from database
     * @param gid
     * @return true
     */
    @RequestMapping(value = "/gid/{gid}", method = RequestMethod.DELETE)
    public boolean deleteBySessionGroupId(@PathVariable String gid) {
        return mSessionService.deleteSessionsBySessionGroupId(gid);
    }

    /**
     * PUT [url]:8080/session/summary
     * Updates session summary for the selected session in the database
     * @param sessionRequest
     * @return SensorsResponse
     */
    @RequestMapping(value = "/summary", method = RequestMethod.PUT)
    public SessionResponse editSessionSummary(@RequestBody SessionRequest sessionRequest) {
        return mSessionService.editSessionSummary(sessionRequest);
    }

    /**
     * PUT [url]:8080/session/exercises
     * Updates session exercises for the selected session in the database
     * @param sessionRequest
     * @return SensorsResponse
     */
    @RequestMapping(value = "/exercises", method = RequestMethod.PUT)
    public SessionResponse editSessionExercises(@RequestBody SessionRequest sessionRequest) {
        return mSessionService.editSessionExercises(sessionRequest);
    }

    /**
     * PUT [url]:8080/session/notes
     * Updates session notes for the selected session in the database
     * @param sessionRequest
     * @return SensorsResponse
     */
    @RequestMapping(value = "/notes", method = RequestMethod.PUT)
    public SessionResponse editSessionNotes(@RequestBody SessionRequest sessionRequest) {
        return mSessionService.editSessionNotes(sessionRequest);
    }
}
