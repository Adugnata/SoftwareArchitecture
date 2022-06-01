package com.enterpriseservicebus;

public class DomesticShippingRouter {
    public String route(Order order) {
        String destinationChannel;
        if (order.getAmount() >= 175) {
            destinationChannel = "nextdayshippingchannel";
        } else {
            destinationChannel = "normalshippingchannel";
        }
        return destinationChannel;
    }
}
