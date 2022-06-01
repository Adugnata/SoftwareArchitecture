package com.order;

public class OrderRouter {
    public String route(Order order) {
        String destinationChannel = null;
        if (order.isRush())
            destinationChannel = "rushorderservicechannel";
        else if (order.getAmount() > 20000)
            destinationChannel = "largeorderservicechannel";
        else
            destinationChannel = "orderservicechannel";
        return destinationChannel;
    }
}