package org.restaurant.order_compose_machine.service;

import java.time.LocalDateTime;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

  @Autowired private OrderRepository orderRepository;
  @Autowired private OrderMapper orderMapper;

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
  public OrderDto createOrder(OrderDto orderDto) {
    Order order = orderMapper.toEntity(orderDto);
    try {
      order = orderRepository.save(order);
      log.info(
          "Order {} has been successfully saved at {}", order.getOrderId(), LocalDateTime.now());
      return orderMapper.toDto(order);
    } catch (Exception e) {
      log.error("Error saving order: {}", e.getMessage(), e);
      throw new RuntimeException("Failed to save order", e);
    }
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
