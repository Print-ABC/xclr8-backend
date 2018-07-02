package com.xclr8.api.service;

import com.xclr8.api.model.Chat;
import com.xclr8.api.model.ChatLog;
import com.xclr8.api.repository.ChatRepository;
import com.xclr8.api.web.request.ChatRequest;
import com.xclr8.api.web.response.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * Creates a chat object in the database
     * @param chatInstance
     * @return boolean
     */
    public boolean createNewChat(ChatRequest chatInstance) {
        Chat chat = new Chat();
        chat.setPatientHealthId(chatInstance.getPatientHealthId());
        chat.setTherapistHealthId(chatInstance.getTherapistHealthId());

        ChatLog chatlog = new ChatLog();
        chatlog.setRecipient(chatInstance.getRecipient());
        chatlog.setSender(chatInstance.getSender());
        chatlog.setText(chatInstance.getText());

        ArrayList<ChatLog> chatLogList = new ArrayList<ChatLog>();
        chatLogList.add(chatlog);
        chat.setChatLog(chatLogList);

        chat = mChatRepository.save(chat);
        return false;
    }

    /**
     * Remove chats with matching document ids from database
     * @param id
     * @return true
     */
    public boolean deleteById(String id) {
        mChatRepository.deleteById(id);
        return true;
    }

    /**
     * Remove chats with matching patient ids from database
     * @param hid
     * @return
     */
    public boolean deleteByPatientHealthId(String hid) {
        mChatRepository.deleteByPatientHealthId(hid);
        return true;
    }

    /**
     * Remove chats with matching therapist ids from database
     * @param hid
     * @return
     */
    public boolean deleteByTherapistHealthId(String hid) {
        mChatRepository.deleteByTherapistHealthId(hid);
        return true;
    }
}