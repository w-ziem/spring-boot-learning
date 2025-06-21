package com.wziem.store;


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


@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService(@Qualifier("stripe") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.processPayment(100);
    }

    public void setPaymentService(@Qualifier("paypal") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

}
