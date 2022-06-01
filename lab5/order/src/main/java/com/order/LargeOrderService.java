package com.order;

import org.springframework.stereotype.Service;

@Service
public class LargeOrderService {
    public void handle(Order order) {
        System.out.println("LargeOrderService receiving order: "+ order.toString());
    }
}