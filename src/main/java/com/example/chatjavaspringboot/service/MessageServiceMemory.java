package com.example.chatjavaspringboot.service;

import com.example.chatjavaspringboot.model.ChatForm;
import com.example.chatjavaspringboot.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceMemory {
    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct(){
        //System.out.println("*****Creating MessageService bean*****");
        this.chatMessages = new ArrayList<>();
        /*ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserName("Jorge");
        chatMessage.setMessage("Hola chat");
        this.chatMessages.add(chatMessage);*/
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();

        newMessage.setUsername(chatForm.getUserName());

        switch (chatForm.getMessageType()){
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

        this.chatMessages.add(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }
}
