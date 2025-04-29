package org.restaurant.order_compose_machine.service;

import jakarta.validation.Valid;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.controller.OrderItemController;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
  private static final Logger log = LoggerFactory.getLogger(OrderItemController.class);

  @Autowired private OrderRepository orderRepository;

  @Autowired private OrderMapper orderMapper;


  @Override
  public ResponseEntity<ApiResponse<String>> getOrderItem(Long id) {
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), String.format("Order item :%x",id), "orderItemDto"));
  }

  @Override
  public ResponseEntity<ApiResponse<String>> getOrderItems() {
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "All order items returned", "orderItemDto"));
  }

  @Override
  public ResponseEntity<ApiResponse<OrderItemDto>> addOrderItem(@Valid OrderItemDto orderItemDto) {
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Order item added", orderItemDto));
  }

  public ResponseEntity<ApiResponse<OrderItemDto>> deleteOrderItem(@Valid OrderItemDto orderItemDto, Long id) {
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), String.format("Order item :%x deleted",id), orderItemDto));
  }

  @Override
  public ResponseEntity<ApiResponse<OrderItemDto>> updateOrderItem(@Valid OrderItemDto orderItemDto, Long id) {
    return ResponseEntity.ok(
        new ApiResponse<>(
            HttpStatus.OK.value(), String.format("Order item :%x updated", id), orderItemDto));
  }
}
