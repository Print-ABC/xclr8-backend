package com.xclr8.api.web.response;

import com.xclr8.api.model.Session;
import com.xclr8.api.model.nestedModel.Exercise;
import com.xclr8.api.model.nestedModel.Summary;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
