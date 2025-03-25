package org.restaurant.order_compose_machine.enums.payment;

public enum PaymentStatus {
  PENDING, // Payment is pending, hasn't been processed yet
  COMPLETED, // Payment has been successfully completed
  FAILED, // Payment failed due to some error
  CANCELLED, // Payment was cancelled by the user or system
  REFUNDED, // Payment has been refunded to the user
  PARTIALLY_PAID, // Only a part of the total payment has been received
  AUTHORIZED, // Payment has been authorized, but not yet captured
  DECLINED // Payment was declined by the payment processor
}
