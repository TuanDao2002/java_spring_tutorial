package com.cosc2440.week5;

import com.cosc2440.week5.service.MessageService;

public class ChatApplication {
    private MessageService messageService;

    // must have getter and setter for ChatApplication to inject MessageService instance
    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
