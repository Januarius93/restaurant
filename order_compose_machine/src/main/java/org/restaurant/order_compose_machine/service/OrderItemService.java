package org.restaurant.order_compose_machine.service;

import jakarta.validation.Valid;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.springframework.http.ResponseEntity;

public interface OrderItemService {

    ResponseEntity<ApiResponse<String>> getOrderItems();

    ResponseEntity<ApiResponse<String>> getOrderItem(@Valid Long id);

    ResponseEntity<ApiResponse<OrderItemDto>> addOrderItem(@Valid OrderItemDto orderItemDto);

    ResponseEntity<ApiResponse<OrderItemDto>> deleteOrderItem(
            @Valid OrderItemDto orderItemDto, Long id);

    ResponseEntity<ApiResponse<OrderItemDto>> updateOrderItem(OrderItemDto orderItemDto, Long id);
}
