package org.example.service;

import org.example.model.Order;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    public List<Order> findNewOrders(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getStatus() == Order.Status.NEW)
                .collect(Collectors.toList());
    }

    public List<Order> findShippedOrdersForCustomer(List<Order> orders, String customer) {
        return orders.stream()
                .filter(o -> o.getStatus() == Order.Status.SHIPPED)
                .filter(o -> o.getCustomer().equalsIgnoreCase(customer))
                .collect(Collectors.toList());
    }

    public double calculateTotalRevenue(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getStatus() == Order.Status.SHIPPED)
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }
}
