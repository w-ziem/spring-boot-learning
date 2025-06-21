package com.wziem.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    private NotificationService service;

    public NotificationManager(NotificationService service){
        this.service = service;
    }

    public void sendNotification(String message){
        service.send(message);
    }

}
