package com.xclr8.api.web.controller;

import com.xclr8.api.service.SessionService;
import com.xclr8.api.web.request.SessionRequest;
import com.xclr8.api.web.response.SessionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/session")
public class SessionController {
    @Autowired
    SessionService mSessionService;


    /**
     * POST [url]:8080/session/create
     * Creates a session object in the database
     * @param sessionRequest
     * @return SessionResponse
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public SessionResponse createSession(@RequestBody SessionRequest sessionRequest) {
        return mSessionService.createSession(sessionRequest);
    }
}
