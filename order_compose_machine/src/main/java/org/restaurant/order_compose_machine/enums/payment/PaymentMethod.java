package org.restaurant.order_compose_machine.enums.payment;

public enum PaymentMethod {
  DEBIT_CARD, // Payment made via debit card
  PAYPAL, // Payment made via PayPal
  BANK_TRANSFER, // Payment made through a bank transfer
  CASH, // Payment made using cash (e.g., at a physical store)
  CRYPTOCURRENCY, // Payment made using cryptocurrency (e.g., Bitcoin, Ethereum)
  GIFT_CARD, // Payment made using a gift card (e.g., Amazon, Visa gift card)
  APPLE_PAY,
  GOOGLE_PAY, // Payment made via mobile apps (e.g., Apple Pay, Google Pay)
  BLIK, // Payment made via paper check
}
