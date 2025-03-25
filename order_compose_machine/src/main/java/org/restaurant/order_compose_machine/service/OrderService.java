package org.restaurant.order_compose_machine.service;

import jakarta.validation.Valid;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;

public interface OrderService {
  ApiResponse<OrderDto> proceedWithOrder(@Valid OrderDto orderDto);
  ApiResponse<OrderItemDto> addOrderItem(@Valid OrderItemDto orderItemDto);
}
