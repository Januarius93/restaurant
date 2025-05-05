package org.restaurant.order_compose_machine.service;

import com.restaurant.dependencies.dto.order.OrderDto;
import com.restaurant.dependencies.dto.order.OrderMapper;
import com.restaurant.dependencies.dto.order_item.OrderItemDto;
import com.restaurant.dependencies.dto.order_item.OrderItemMapper;
import com.restaurant.dependencies.model.order.Order;
import com.restaurant.dependencies.model.order.OrderItem;
import jakarta.validation.Valid;
import java.util.List;
import lombok.SneakyThrows;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.exceptions.OrderExceptions;
import org.restaurant.order_compose_machine.exceptions.OrderItemExceptions;
import org.restaurant.order_compose_machine.repository.OrderItemRepository;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
  private static final Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);

  @Autowired private OrderServiceImpl orderService;
  @Autowired private OrderRepository orderRepository;

  @Autowired private OrderItemRepository orderItemRepository;

  @Autowired private OrderMapper orderMapper;
  @Autowired private OrderItemMapper orderItemMapper;

  @Override
  public ResponseEntity<ApiResponse<String>> getOrderItem(Long id) {
    return ResponseEntity.ok(
        new ApiResponse<>(
            HttpStatus.OK.value(), String.format("Order item :%x", id), "orderItemDto"));
  }

  @Override
  public ResponseEntity<ApiResponse<String>> getOrderItems() {
    return ResponseEntity.ok(
        new ApiResponse<>(HttpStatus.OK.value(), "All order items returned", "orderItemDto"));
  }

  @Override
  public OrderDto addOrderItem(@Valid OrderItemDto orderItemDto, Long orderId) {
    Order orderToAddOrderItems =
        orderRepository
            .findById(orderId)
            .orElseThrow(() -> new OrderExceptions.OrderNotFoundException(orderId));
    orderToAddOrderItems.getListOfOrderItems().add(orderItemMapper.toEntity(orderItemDto));
    orderService.updateOrder(orderMapper.toDto(orderToAddOrderItems), orderId);
    return orderMapper.toDto(orderToAddOrderItems);
  }

  @Override
  public OrderDto addOrderItems(@Valid List<OrderItemDto> listOfOrderItemsDto, Long orderId) {
    Order orderToAddOrderItems =
        orderRepository
            .findById(orderId)
            .orElseThrow(() -> new OrderExceptions.OrderNotFoundException(orderId));

    List<OrderItem> listOfOrderItems =
        listOfOrderItemsDto.stream()
            .map(orderItemDto -> orderItemMapper.toEntity(orderItemDto))
            .toList();

    orderToAddOrderItems.getListOfOrderItems().addAll(listOfOrderItems);
    orderService.updateOrder(orderMapper.toDto(orderToAddOrderItems), orderId);
    return orderMapper.toDto(orderToAddOrderItems);
  }

  @SneakyThrows
  public OrderDto deleteOrderItem(Long orderId, Long orderItemToBeRemovedId) {
    Order orderWhereOrderItemWillBeRemoved =
        orderRepository
            .findById(orderId)
            .orElseThrow(() -> new OrderExceptions.OrderNotFoundException(orderId));

    List<OrderItem> orderItemList =
        orderWhereOrderItemWillBeRemoved.getListOfOrderItems().stream()
            .filter(orderItem -> orderItem.getOrderItemId().equals(orderItemToBeRemovedId))
            .toList();

    int orderItemListSize = orderItemList.size();
    if (orderItemListSize == 0) {
      log.error("OrderItem: {} not found", orderItemToBeRemovedId);
      throw new OrderItemExceptions.OrderItemNotFoundException(orderItemToBeRemovedId);
    }
    if (orderItemListSize > 1) {
      log.warn("Found two or more orderItems with the same id: {}", orderItemToBeRemovedId);
      throw new OrderItemExceptions.OrderItemDoubledIdsException(orderItemToBeRemovedId);
    }

    orderWhereOrderItemWillBeRemoved
        .getListOfOrderItems()
        .remove(orderItemList.stream().findFirst().get());
    return orderMapper.toDto(orderWhereOrderItemWillBeRemoved);
  }

  @Override
  public OrderDto updateOrderItem(@Valid OrderItemDto orderItemDto, Long id) {
    return OrderDto.builder().build();
    //        return ResponseEntity.ok(
    //                new ApiResponse<>(
    //                        HttpStatus.OK.value(), String.format("Order item :%x updated", id),
    // orderItemDto));
  }
}
