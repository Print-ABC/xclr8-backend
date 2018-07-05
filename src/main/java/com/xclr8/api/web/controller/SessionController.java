package com.xclr8.api.web.controller;

import com.xclr8.api.service.SessionService;
import com.xclr8.api.web.request.SessionRequest;
import com.xclr8.api.web.response.SessionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
