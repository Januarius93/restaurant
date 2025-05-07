package org.restaurant.order_compose_machine.service;

import com.restaurant.dependencies.dto.MenuDto;
import com.restaurant.dependencies.dto.order.OrderDto;
import jakarta.validation.Valid;
import java.util.List;

public interface OrderService {
  List<OrderDto> getOrders();

  OrderDto getOrder(Long id);

  OrderDto createOrder(@Valid OrderDto dto);

  OrderDto updateOrder(@Valid OrderDto orderDto, Long id);

  OrderDto deleteOrder(Long id);

  MenuDto getMenu();
}
