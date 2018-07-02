package com.xclr8.api.web.controller;

import com.xclr8.api.service.ChatService;
import com.xclr8.api.web.request.ChatRequest;
import com.xclr8.api.web.response.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * Return all chat logs filtered by given therapist health ID from database
     * @return Iterable<ChatResponse>
     */
    @RequestMapping(value = "/t/{tHid}", method = RequestMethod.GET)
    public Iterable<ChatResponse> chatsByTherapistHealthId(@PathVariable String tHid) {
        return mChatService.findChatByTherapistHealthId(tHid);
    }

    /**
     * GET [url]:8080/chat/p/[patient health id]
     * Return all chat logs filtered by given patient health ID from database
     * @return Iterable<ChatResponse>
     */
    @RequestMapping(value = "/p/{pHid}", method = RequestMethod.GET)
    public Iterable<ChatResponse> chatsByPatientHealthId(@PathVariable String pHid) {
        return mChatService.findChatByPatientHealthId(pHid);
    }

    /**
     * POST [url]:8080/chat/create
     * Creates a chat log on the database
     * @return boolean
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public boolean createText(@RequestBody ChatRequest Chat) {
        return mChatService.createNewChat(Chat);
    }

    /**
     * DELETE [url]:8080/chat/delete/id/[document id]
     * Delete all chat logs filtered by given document ID from database
     * @return true
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean deleteChatById(@PathVariable String id) {
        return mChatService.deleteById(id);
    }

    /**
     * DELETE [url]:8080/chat/delete/p/[patient health id]
     * Delete all chat logs filtered by given patient health ID from database
     * @return true
     */
    @RequestMapping(value = "/delete/p/{phid}", method = RequestMethod.DELETE)
    public boolean deleteChatByPatientHealthId(@PathVariable String phid) {
        return mChatService.deleteByPatientHealthId(phid);
    }

    /**
     * DELETE [url]:8080/chat/delete/t/[therapist health id]
     * Delete all chat logs filtered by given therapist health ID from database
     * @return true
     */
    @RequestMapping(value = "/delete/t/{thid}", method = RequestMethod.DELETE)
    public boolean deleteChatByTherapistHealthId(@PathVariable String thid) {
        return mChatService.deleteByTherapistHealthId(thid);
    }
}
