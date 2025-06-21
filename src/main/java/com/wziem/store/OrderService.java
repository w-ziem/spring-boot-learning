package com.wziem.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Spring annotations: for Spring IOC Container
- Component: general purpose (utility classes)
- Service: classes that contain busienss logic
- Repository: classes that interact with database
- Controller: marking classes as controllers for handling web requests

 */


@Service
public class OrderService {

    private PaymentService paymentService;

    @Autowired //for when you have multiple constructors
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public OrderService(PaymentService paymentService, int x) {}

    public void placeOrder() {
        paymentService.processPayment(100);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

}
