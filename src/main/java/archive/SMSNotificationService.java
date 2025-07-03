package archive;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService{
    @Override
    public void send(String message, String recipient){
        System.out.println("SMS service: ");
        System.out.println("Sending SMS to: " + recipient);
        System.out.println("SMS sent: " + message);
    }
}
