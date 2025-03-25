package org.restaurant.order_compose_machine.service;

import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.controller.OrderController;

import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
  private static final Logger log = LoggerFactory.getLogger(OrderController.class);

  @Autowired private OrderRepository orderRepository;

  @Autowired private OrderMapper orderMapper;

  @Override
  public ApiResponse<OrderDto> proceedWithOrder(OrderDto orderDto) {
    Order order = orderMapper.toEntity(orderDto);
    Order savedOrder;
    try {
      savedOrder = orderRepository.save(order);
    } catch (Exception e) {
      ApiResponse.<OrderDto>builder()
              .httpStatusCode(HttpStatus.BAD_REQUEST)
              .message("something wrong with request")
              .data(orderDto)
              .build();
    }
    orderDto.setId(order.getId());
    return ApiResponse.<OrderDto>builder()
        .httpStatusCode(HttpStatus.OK)
        .message("order placed")
        .data(orderDto)
        .build();
  }
}
