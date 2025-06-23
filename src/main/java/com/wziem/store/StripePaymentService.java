package com.wziem.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Controlling bean selection:
- @Primary: if there are multiple beans of the same type, this one will be selected
- @Qualifier: select a bean by name
 */

//@Service("stripe")
//@Primary
public class StripePaymentService implements PaymentService {
    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private boolean enabled;

    @Value("${stripe.timeout:3000}") // deafult value if not defined in application properties is 3000
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;


    @Override
    public void processPayment(double amount) {

        System.out.println("STRIPE");
        System.out.println("APIURL: " + apiUrl);
        System.out.println("Enabled: " + enabled);
        System.out.println("Timeout: " + timeout);
        System.out.println("SupportedCurrencies: " + supportedCurrencies);
        System.out.println("Amount: " + amount);
    }
}
