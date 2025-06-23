package com.wziem.store;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var orderService  = context.getBean(OrderService.class);
        orderService.placeOrder();

        //orderService object is created (it's bean) even tho I don't use it - early/eger initialization


        var notificationManager = context.getBean(NotificationManager.class);
        notificationManager.sendNotification("Order placed successfully!");

        var resource = context.getBean(HeavyResource.class);

    }

}
