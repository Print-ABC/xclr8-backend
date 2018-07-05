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
     * GET [url]:8080/session/all
     * Return all available sessions from database
     * @return Iterable<SessionResponse>
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
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
     * POST [url]:8080/session/create
     * Creates a session object in the database
     * @param sessionRequest
     * @return SessionResponse object
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public SessionResponse createSession(@RequestBody SessionRequest sessionRequest) {
        return mSessionService.createSession(sessionRequest);
    }
}
