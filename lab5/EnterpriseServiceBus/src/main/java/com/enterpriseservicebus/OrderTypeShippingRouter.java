package com.enterpriseservicebus;

public class OrderTypeShippingRouter {
    public String route(Order order) {
        String outputChannel;
        if (order.getOrderType() == Order.OrderType.DOMESTIC) {
            outputChannel = "domesticshippingchannel";
        } else {
            outputChannel = "internationalshippingchannel";
        }
        return outputChannel;
    }
}
