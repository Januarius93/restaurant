package org.restaurant.order_compose_machine.service;

import jakarta.validation.Valid;
import java.util.List;
import org.restaurant.order_compose_machine.dto.order.OrderDto;

public interface OrderService {
  List<OrderDto> getOrders();

  OrderDto getOrder(Long id);

  OrderDto createOrder(@Valid OrderDto dto);

  OrderDto updateOrder(@Valid OrderDto orderDto, Long id);

  OrderDto deleteOrder(Long id);
}
