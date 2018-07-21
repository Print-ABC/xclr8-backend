package com.xclr8.api.web.response;

import com.xclr8.api.model.Session;
import com.xclr8.api.model.nestedModel.Summary;
import lombok.Data;

@Data
public class SessionSummaryResponse {
    String id;
    Summary sessionSummary;

    /**
     * Create an SessionResponse from an Session object and return it
     * @param session
     * @return sessionResponse
     */
    public SessionSummaryResponse sessionResponse(Session session){
        SessionSummaryResponse sessionResponse = new SessionSummaryResponse();
        sessionResponse.setId(session.getId());
        sessionResponse.setSessionSummary(session.getSessionSummary());
        return sessionResponse;
    }
}
