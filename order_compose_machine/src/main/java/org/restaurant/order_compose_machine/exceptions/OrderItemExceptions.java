package org.restaurant.order_compose_machine.exceptions;

public class OrderItemExceptions {
  public static class FailedToException extends RuntimeException {
    public FailedToException(String customExceptionMessage, Exception e) {
      super(customExceptionMessage, e);
    }
  }

  public static class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long orderId) {
      super(String.format("Order item %s not found", orderId));
    }
  }

  public static class OrderItemDoubledIdsException extends Throwable {
    public OrderItemDoubledIdsException(Long orderId) {
      super(String.format("Found two or more orderItems with the same id: %s", orderId));
    }
  }
}
