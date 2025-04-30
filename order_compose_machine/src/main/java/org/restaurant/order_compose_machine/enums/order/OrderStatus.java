package org.restaurant.order_compose_machine.enums.order;

public enum OrderStatus {
    PENDING,
    CONFIRMED,
    PREPARING,
    READY_FOR_DELIVERY,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED,
    FAILED,
    COMPLETED,
    REFUNDED
}
