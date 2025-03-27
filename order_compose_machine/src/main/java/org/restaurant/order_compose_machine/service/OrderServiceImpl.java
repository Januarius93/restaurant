package org.restaurant.order_compose_machine.service;

import jakarta.validation.Valid;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.controller.OrderController;
import org.restaurant.order_compose_machine.controller.OrderItemController;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
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
}
