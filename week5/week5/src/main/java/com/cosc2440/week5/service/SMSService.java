package com.cosc2440.week5.service;

import org.springframework.stereotype.Component;

// use @Component for SMSService instead of creating Bean in AppConfig class
@Component
public class SMSService implements MessageService {
    @Override
    public void send() {
        System.out.println("SMS service");
    }
}
