package com.ejbs.store;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service //Deja que spring lo maneje como bean Equivalente a @Service (Clases con business logic) y component para utility
public class OrderService {

    @Getter
    @Setter
    private PaymentService paymentService;

    //@Autowired Ocupado para cuando solo se tiene mas de un constructor
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }
}
