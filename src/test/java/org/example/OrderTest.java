package org.example;

import org.example.model.Order;
import org.example.service.OrderService;
import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("📦 Order Service Tests")
class OrderTest {

    private OrderService service;

    @BeforeEach
    void setup() {
        service = new OrderService();
    }

    @Test
    @DisplayName("Should calculate total shipped order revenue")
    void testRevenueFromShippedOrders() {
        var orders = List.of(
                new Order("O1", "Ali", 100, Order.Status.SHIPPED),
                new Order("O2", "Ali", 50, Order.Status.NEW),
                new Order("O3", "Ali", 150, Order.Status.SHIPPED)
        );

        double total = service.calculateTotalRevenue(orders);
        assertEquals(250.0, total, 0.001);
    }

    @Test
    @DisplayName("Should return empty list for no SHIPPED orders")
    void testNoShippedOrders() {
        var empty = service.findShippedOrdersForCustomer(Collections.emptyList(), "Ali");
        assertTrue(empty.isEmpty());
    }

    @Test
    @DisplayName("Should throw exception for negative order amount")
    void testNegativeOrderAmount() {
        assertThrows(IllegalArgumentException.class, () ->
                new Order("X", "Fail", -100, Order.Status.NEW)
        );
    }
}
