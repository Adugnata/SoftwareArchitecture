package com.order;

import org.springframework.stereotype.Service;

@Service
public class RushOrderService {
    public void handle(Order order) {
        System.out.println("RushOrderService receiving order: "+ order.toString());
    }
}
