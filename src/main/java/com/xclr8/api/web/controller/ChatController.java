package com.xclr8.api.web.controller;

import com.xclr8.api.model.Chat;
import com.xclr8.api.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatRepository mChatRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Chat> chats() {
        return mChatRepository.findAll();
    }
}
