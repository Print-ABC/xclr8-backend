package com.xclr8.api.web.response;

import com.xclr8.api.model.Chat;
import com.xclr8.api.model.ChatLog;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatResponse {
    private String id;
    private String therapist_healthId;
    private String patient_healthId;
    private List<ChatLog> chatLog;

    public static Iterable<ChatResponse> toAllChatResponse(Iterable<Chat> cList){
        ArrayList<ChatResponse> cRList = new ArrayList<ChatResponse>();
        for (Chat c : cList) {
            ChatResponse cR = new ChatResponse();
            cR.setId(c.getId());
            cR.setTherapist_healthId(c.getTherapist_healthId());
            cR.setPatient_healthId(c.getPatient_healthId());
            cR.setChatLog(c.getChatLog());
            cRList.add(cR);
        }

        return cRList;
    }

}
