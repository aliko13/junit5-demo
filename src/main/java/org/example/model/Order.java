package org.example.model;

public class Order {
    public enum Status { NEW, PROCESSING, SHIPPED, CANCELLED }

    private final String orderId;
    private final String customer;
    private final double totalAmount;
    private final Status status;

    public Order(String orderId, String customer, double totalAmount, Status status) {
        if (totalAmount < 0) throw new IllegalArgumentException("Total amount must be positive");
        this.orderId = orderId;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Status getStatus() {
        return status;
    }
}
