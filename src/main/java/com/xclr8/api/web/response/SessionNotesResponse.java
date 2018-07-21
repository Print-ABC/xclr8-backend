package com.xclr8.api.web.response;

import com.xclr8.api.model.Session;
import lombok.Data;

@Data
public class SessionNotesResponse {
    String id;
    String notes;

    /**
     * Create an SessionResponse from an Session object and return it
     * @param session
     * @return sessionResponse
     */
    public SessionNotesResponse sessionResponse(Session session){
        SessionNotesResponse sessionResponse = new SessionNotesResponse();
        sessionResponse.setId(session.getId());
        sessionResponse.setNotes(session.getNotes());
        return sessionResponse;
    }
}
