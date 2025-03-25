package org.restaurant.order_compose_machine.enums.order;

public enum OrderStatus {
    PENDING,             // Order has been created but not yet processed
    CONFIRMED,           // Order has been confirmed by the system or restaurant
    PREPARING,           // The order is being prepared
    READY_FOR_DELIVERY,  // Order is ready for delivery or pickup
    OUT_FOR_DELIVERY,    // Order is currently being delivered
    DELIVERED,           // Order has been successfully delivered or picked up
    CANCELLED,           // Order has been cancelled
    FAILED,              // Order failed due to some issue (e.g., payment failure)
    COMPLETED,           // Order has been completed successfully
    REFUNDED             // Order payment has been refunded
}
