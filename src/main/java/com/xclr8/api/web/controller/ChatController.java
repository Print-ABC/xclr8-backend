package com.xclr8.api.web.controller;

import com.xclr8.api.exception.CustomBadRequestException;
import com.xclr8.api.exception.CustomNotFoundException;
import com.xclr8.api.exception.ExceptionMessage;
import com.xclr8.api.model.Chat;
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

    ExceptionMessage mExceptionMessage;

    /**
     * GET [url]:8080/chat
     * Return all available chats from database
     * @return Iterable<ChatResponse>
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ChatResponse> chats() {
        Iterable<ChatResponse> chats = mChatService.findAllChat();
        if(!chats.iterator().hasNext())
            throw new CustomNotFoundException(mExceptionMessage.EMPTY.getMsg());
        return chats;
    }

    /**
     * GET [url]:8080/chat/therapist/[therapist health id]
     * Return all chat logs filtered by given therapist health ID from database
     * @return Iterable<ChatResponse>
     */
    @RequestMapping(value = "/therapist/{tHid}", method = RequestMethod.GET)
    public Iterable<ChatResponse> chatsByTherapistHealthId(@PathVariable String tHid) {
        return mChatService.findChatByTherapistHealthId(tHid);
    }

    /**
     * GET [url]:8080/chat/patient/[patient health id]
     * Return all chat logs filtered by given patient health ID from database
     * @return Iterable<ChatResponse>
     */
    @RequestMapping(value = "/patient/{pHid}", method = RequestMethod.GET)
    public Iterable<ChatResponse> chatsByPatientHealthId(@PathVariable String pHid) {
        return mChatService.findChatByPatientHealthId(pHid);
    }

    /**
     * POST [url]:8080/chat
     * Creates a chat log on the database
     * @return Chat
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Chat createText(@RequestBody ChatRequest chat) {
        if((chat.getId() == null) || (chat.getTherapistHealthId() == null) || (chat.getPatientHealthId() == null)
                || (chat.getSender() == null) || (chat.getRecipient() == null) || (chat.getText() == null))
            throw new CustomBadRequestException(mExceptionMessage.REQUEST_BODY_ERROR.getMsg());
        return mChatService.createNewChat(chat);
    }

    /**
     * PUT [url]:8080/chat
     * Adds a new message into a currently existing ChatLog in the database
     * Only really uses chat objectID, sender, recipient and text to update the chatlog
     * @return Chat
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Chat sendMessage(@RequestBody ChatRequest chat) {
        return mChatService.sendMessage(chat);
    }

    /**
     * DELETE [url]:8080/chat/[document id]
     * Delete all chat logs filtered by given document ID from database
     * @return true
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteChatById(@PathVariable String id) {
        return mChatService.deleteById(id);
    }

    /**
     * DELETE [url]:8080/chat/therapist/[therapist health id]
     * Delete all chat logs filtered by given therapist health ID from database
     * @return true
     */
    @RequestMapping(value = "/therapist/{tHid}", method = RequestMethod.DELETE)
    public boolean deleteChatByTherapistHealthId(@PathVariable String tHid) {
        return mChatService.deleteByTherapistHealthId(tHid);
    }

    /**
     * DELETE [url]:8080/chat/patient/[patient health id]
     * Delete all chat logs filtered by given patient health ID from database
     * @return true
     */
    @RequestMapping(value = "/patient/{pHid}", method = RequestMethod.DELETE)
    public boolean deleteChatByPatientHealthId(@PathVariable String pHid) {
        return mChatService.deleteByPatientHealthId(pHid);
    }
}
