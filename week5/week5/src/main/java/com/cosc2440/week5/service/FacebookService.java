package com.cosc2440.week5.service;

import org.springframework.context.annotation.Scope;

public class FacebookService implements MessageService {
    @Override
    public void send() {
        System.out.println("Facebook Service");
    }
}
