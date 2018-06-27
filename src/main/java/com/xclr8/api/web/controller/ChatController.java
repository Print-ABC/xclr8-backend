package com.xclr8.api.web.controller;

import com.xclr8.api.service.ChatService;
import com.xclr8.api.web.response.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatService mChatService;

    /**
     * GET [url]:8080/chat
     * Return all available chats from database
     * @return Iterable<ChatResponse>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ChatResponse> chats() {
        return mChatService.findAllChat();
    }

    /**
     * GET [url]:8080/chat/t/[therapist health id]
     * Return all chat logs filtered by therapist health IDs from database
     * @return Iterable<ChatResponse>
     */
    @RequestMapping(value = "/t/{tHid}", method = RequestMethod.GET)
    public Iterable<ChatResponse> chatsByTherapistHealthId(@PathVariable String tHid) {
        return mChatService.findChatByTherapistHealthId(tHid);
    }

    /**
     * GET [url]:8080/chat/p/[patient health id]
     * Return all chat logs filtered by patient health IDs from database
     * @return Iterable<ChatResponse>
     */
    @RequestMapping(value = "/p/{pHid}", method = RequestMethod.GET)
    public Iterable<ChatResponse> chatsByPatientHealthId(@PathVariable String pHid) {
        return mChatService.findChatByPatientHealthId(pHid);
    }
}
