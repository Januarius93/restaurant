package org.restaurant.order_compose_machine.service;


import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
  private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

  @Override
  public ResponseEntity<ApiResponse<String>> getOrders() {
    return ResponseEntity.ok(
        new ApiResponse<>(HttpStatus.OK.value(), "All orders returned", "order"));
  }

  @Override
  public ResponseEntity<ApiResponse<String>> getOrder(Long id) {
    return ResponseEntity.ok(
        new ApiResponse<>(HttpStatus.OK.value(), String.format("Order :%x", id), "order"));
  }

  @Override
  public ResponseEntity<ApiResponse<OrderDto>> createOrder(OrderDto orderDto) {
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Order created", orderDto));
  }

  @Override
  public ResponseEntity<ApiResponse<OrderDto>> updateOrder(OrderDto orderDto, Long id) {
    return ResponseEntity.ok(
        new ApiResponse<>(HttpStatus.OK.value(), String.format("Order :%x updated", id), orderDto));
  }

  @Override
  public ResponseEntity<ApiResponse<OrderDto>> deleteOrder(OrderDto orderDto, Long id) {
    return ResponseEntity.ok(
            new ApiResponse<>(HttpStatus.OK.value(), String.format("Order :%x deleted", id), orderDto));
  }
}
