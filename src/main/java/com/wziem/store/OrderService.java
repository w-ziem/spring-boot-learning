package com.wziem.store;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
Spring annotations: for Spring IOC Container
- Component: general purpose (utility classes)
- Service: classes that contain busienss logic
- Repository: classes that interact with database
- Controller: marking classes as controllers for handling web requests

 */


//@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderSevice created");
    }

    @PostConstruct //this method will be called after bean is initializated
    public void init(){
        System.out.println("OrderService PostConstruct");
    }

    @PreDestroy //self explanatroy, a good moment to celan up memeory, close connections, relesase file handlers, threads
    public void clenaUp(){
        System.out.println("OrderService PreDestroy");
    }

    public void placeOrder() {
        paymentService.processPayment(100);
    }

}
