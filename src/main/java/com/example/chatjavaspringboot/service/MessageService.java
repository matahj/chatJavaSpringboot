package com.example.chatjavaspringboot.service;

import com.example.chatjavaspringboot.mapper.MessageMapper;
import com.example.chatjavaspringboot.model.ChatForm;
import com.example.chatjavaspringboot.model.ChatMessage;
//import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUserName());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
        messageMapper.addMessage(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messageMapper.getAllMessages();
    }
}

