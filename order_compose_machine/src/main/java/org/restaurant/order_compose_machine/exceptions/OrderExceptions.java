package org.restaurant.order_compose_machine.exceptions;

public class OrderExceptions {
  public static class FailedToException extends RuntimeException {
    public FailedToException(String customExceptionMessage, Exception e) {
      super(customExceptionMessage, e);
    }
  }

  public static class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
      super(String.format("Order %s not found", orderId));
    }
  }
}
