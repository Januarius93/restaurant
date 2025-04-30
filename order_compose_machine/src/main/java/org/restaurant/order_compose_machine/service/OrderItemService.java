package org.restaurant.order_compose_machine.service;

import jakarta.validation.Valid;
import java.util.List;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.springframework.http.ResponseEntity;

public interface OrderItemService {

  ResponseEntity<ApiResponse<String>> getOrderItems();

  ResponseEntity<ApiResponse<String>> getOrderItem(@Valid Long id);

  OrderDto addOrderItem(@Valid OrderItemDto orderItemDto, Long orderId);

  OrderDto addOrderItems(@Valid List<OrderItemDto> listOfOrderItemsDto, Long orderId);

  OrderDto deleteOrderItem(Long orderId, Long orderItemId);

  OrderDto updateOrderItem(OrderItemDto orderItemDto, Long id);
}
