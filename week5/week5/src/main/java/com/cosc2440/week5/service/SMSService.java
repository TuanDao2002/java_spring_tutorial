package com.cosc2440.week5.service;

public class SMSService implements MessageService {
    @Override
    public void send() {
        System.out.println("SMS service");
    }
}
