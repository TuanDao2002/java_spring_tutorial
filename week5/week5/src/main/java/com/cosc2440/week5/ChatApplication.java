package com.cosc2440.week5;

import com.cosc2440.week5.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

public class ChatApplication {
    // use @Autowired to include the bean of MessageService in ChatApplication
    @Autowired
    // there are many beans that implement interface MessageService
    // => use qualifier to specify which bean in AppConfig class (or class with @Component at the top) is autowired to ChatApplication
    @Qualifier("facebookService")
    private MessageService messageService;

    private ArrayList<MessageService> messageServiceArrayList;

    public ChatApplication(){}

    public ChatApplication(ArrayList<MessageService> messageServiceArrayList) {
        this.messageServiceArrayList = messageServiceArrayList;
    }

    // must have getter and setter for ChatApplication to inject MessageService instance
    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public ArrayList<MessageService> getMessageServiceArrayList() {
        return messageServiceArrayList;
    }
}
