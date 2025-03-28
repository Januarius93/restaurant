package org.restaurant.order_compose_machine.service;

import jakarta.validation.Valid;
import java.util.List;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.springframework.http.ResponseEntity;

public interface OrderService {
  List<OrderDto> getOrders();

  OrderDto getOrder(Long id);

  OrderDto createOrder(@Valid OrderDto dto);

  ResponseEntity<ApiResponse<OrderDto>> updateOrder(@Valid OrderDto orderDto, Long id);

  ResponseEntity<ApiResponse<OrderDto>> deleteOrder(@Valid OrderDto orderDto, Long id);
}
