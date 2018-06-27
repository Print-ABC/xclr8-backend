package com.xclr8.api.service;

import com.xclr8.api.model.Chat;
import com.xclr8.api.repository.ChatRepository;
import com.xclr8.api.web.response.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    ChatRepository mChatRepository;

    /**
     * Return all available chat logs from database
     * @return Iterable<ChatResponse>
     */
    public Iterable<ChatResponse> findAllChat(){
        List<Chat> chatList = mChatRepository.findAll();
        return new ChatResponse().toAllChatResponse(chatList);
    }

    /**
     * Return chat logs filtered by therapist health IDs from database
     * @param tHid
     * @return Iterable<ChatResponse>
     */
    public Iterable<ChatResponse> findChatByTherapistHealthId(String tHid) {
        List<Chat> chatList = mChatRepository.findByTherapistHealthId(tHid);
        return new ChatResponse().toAllChatResponse(chatList);
    }

    /**
     * Return chat logs filtered by patient health IDs from database
     * @param pHid
     * @return Iterable<ChatResponse>
     */
    public Iterable<ChatResponse> findChatByPatientHealthId(String pHid) {
        List<Chat> chatList = mChatRepository.findByPatientHealthId(pHid);
        return new ChatResponse().toAllChatResponse(chatList);
    }
}