package com.order;

public class Order {
    private String orderNumber;
    private double amount;
    private boolean isrush;
    public String getOrderNumber() {
        return orderNumber;
    }

    public double getAmount() {
        return amount;
    }

    public Order(String orderNumber, double amount,boolean isrush) {
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.isrush = isrush;
    }

    public String toString() {
        return "Order: nr=" + orderNumber + " amount=" + amount;
    }

    public boolean isRush() {
        return isrush;
    }
}