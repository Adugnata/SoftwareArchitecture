package com.order;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void handle(Order order) {
        System.out.println("OrderService receiving order: "+ order.toString());
    }
}
