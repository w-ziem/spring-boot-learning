package com.wziem.store;

import org.springframework.stereotype.Service;

@Service //what happens if we annotate Stripe ???
public class PaypalPaymentService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("PAYPAL");
        System.out.println("Amount: " + amount);
    }
}
