package com.wziem.store;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String message){
        System.out.println("SMS sent: " + message);
    }
}
