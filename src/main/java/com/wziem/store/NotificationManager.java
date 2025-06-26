package com.wziem.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    private final NotificationService service;

    public NotificationManager(@Qualifier("sms") NotificationService service){
        this.service = service;
    }

    public void send(String message, String recipient){
        //logic
        service.send(message, recipient);
    }

}
