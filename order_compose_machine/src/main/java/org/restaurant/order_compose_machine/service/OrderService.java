package org.restaurant.order_compose_machine.service;

import jakarta.validation.Valid;
import org.restaurant.order_compose_machine.dto.order.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders();

    OrderDto getOrder(Long id);

    OrderDto createOrder(@Valid OrderDto dto);

    OrderDto updateOrder(@Valid OrderDto orderDto, Long id);

    OrderDto deleteOrder(Long id);
}
