package com.example.chatjavaspringboot.service;

import com.example.chatjavaspringboot.model.ChatForm;
import com.example.chatjavaspringboot.model.ChatMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct(){
        System.out.println("*****Creating MessageService bean*****");
        this.chatMessages = new ArrayList<>();
        /*ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserName("Jorge");
        chatMessage.setMessage("Hola chat");
        this.chatMessages.add(chatMessage);*/
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();

        newMessage.setUserName(chatForm.getUserName());

        switch (chatForm.getMessageType()){
            case "Say":
                newMessage.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getMessageText().toLowerCase());
                break;
        }

        this.chatMessages.add(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }
}
