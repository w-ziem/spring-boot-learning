package com.wziem.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/*
Controlling bean selection:
- @Primary: if there are multiple beans of the same type, this one will be selected
- @Qualifier: select a bean by name
 */

@Service("stripe")
@Primary
public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.println("Amount: " + amount);
    }
}
