package com.xclr8.api.web.controller;

import com.xclr8.api.service.ChatService;
import com.xclr8.api.web.response.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatService mChatService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ChatResponse> chats() {
        return mChatService.findAllChat();
    }
}
