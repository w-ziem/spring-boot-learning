package com.wziem.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    private final NotificationService service;

    public NotificationManager(NotificationService service){
        this.service = service;
    }

    public void sendNotification(String message){
        //logic
        service.send(message);
    }

}
