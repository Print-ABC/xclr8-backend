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
    ChatRepository chatRepository;

    public Iterable<ChatResponse> findAllChat(){
        List<Chat> cList;
        cList = chatRepository.findAll();
        return ChatResponse.toAllChatResponse(cList);
    }
}