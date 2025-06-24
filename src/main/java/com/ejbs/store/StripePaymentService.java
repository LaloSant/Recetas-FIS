package com.ejbs.store;

import org.springframework.stereotype.Service;

@Service 
public class StripePaymentService implements PaymentService{

    @Override
    public void processPayment(float cantidad) {
        System.out.println("""
                           TIPO: Stripe
                           Cantidad: """ + cantidad);
    }
    
}
