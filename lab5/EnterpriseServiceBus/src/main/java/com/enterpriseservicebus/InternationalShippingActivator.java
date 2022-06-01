package com.enterpriseservicebus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class InternationalShippingActivator {
    @Autowired
    RestTemplate restTemplate;

    public void ship(Order order) {
        System.out.println("international shipping: " + order.toString());
        restTemplate.postForLocation("http://localhost:8082/orders/international_shipping", order);
    }
}
