package com.wziem.store;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        //setters vs constructor depencency injection
        var orderService = new OrderService(new StripePaymentService());
        orderService.placeOrder();
        orderService.setPaymentService(new PaypalPaymentService());
        orderService.placeOrder();

        //setters for optional depencencies (null pointer exception not possbile like in placeOrder)
        //constructor (more common and regular way of DI) for required dependencies
    }

}
