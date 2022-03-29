package com.cosc2440.week5.service;

public class HangoutService implements MessageService {
    @Override
    public void send() {
        System.out.println("Hangout service");
    }
}
