package com.xclr8.api.web.response;

import com.xclr8.api.model.Chat;
import com.xclr8.api.nestedModel.ChatLog;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatResponse {
    private String id;
    private String therapist_healthId;
    private String patient_healthId;
    private List<ChatLog> chatLog;

    /**
     * Create a list of ChatResponse object from Chat objects and return it
     * @param chats
     * @return chatResponses
     */
    public Iterable<ChatResponse> chatResponseIterable(Iterable<Chat> chats){
        ArrayList<ChatResponse> chatResponses = new ArrayList<ChatResponse>();
        for (Chat c : chats) {
            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setId(c.getId());
            chatResponse.setTherapist_healthId(c.getTherapistHealthId());
            chatResponse.setPatient_healthId(c.getPatientHealthId());
            chatResponse.setChatLog(c.getChatLog());
            chatResponses.add(chatResponse);
        }
        return chatResponses;
    }

}
