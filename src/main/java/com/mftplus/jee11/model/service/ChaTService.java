package com.mftplus.jee11.model.service;

import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven
public class ChaTService implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(message);

    }
}
