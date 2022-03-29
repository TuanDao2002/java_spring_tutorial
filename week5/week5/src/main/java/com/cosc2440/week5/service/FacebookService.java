package com.cosc2440.week5.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FacebookService implements MessageService {
    @Override
    public void send() {
        System.out.println("Facebook Service");
    }
}
