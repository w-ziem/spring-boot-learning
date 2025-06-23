package com.wziem.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

//class for beans creation manually
@Configuration
public class AppConfig {

    @Value( "${payment.provider:stripe}")
    private String paymentProvider;
    //name of the method will be the name of the bean
    @Bean
    public PaymentService stripe(){
       return new StripePaymentService();
    }


    @Bean
    public PaymentService paypal() {
         return new PaypalPaymentService();
    }

    @Bean
    @Lazy
    public OrderService orderService(){
        if(paymentProvider.equals("stripe")) {
            return new OrderService(stripe());
        } else if (paymentProvider.equals("paypal")) {
            return new OrderService(paypal());
        }
        return null;
    }
}
