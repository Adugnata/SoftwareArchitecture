package com.order;

public class OrderFilter {
    public boolean filter(Order order) {
        if (order.getAmount() > 800)
            return true;
        else
            return false;
    }
}