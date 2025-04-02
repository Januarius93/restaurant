package org.restaurant.order_compose_machine.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
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

  @Autowired private OrderRepository orderRepository;
  @Autowired private OrderMapper orderMapper;

  @Override
  public List<OrderDto> getOrders() {
    List<Order> listOfOrders;
    try {
      listOfOrders = orderRepository.findAll();
      log.info("All orders has been successfully get at {}", LocalDateTime.now());
      return listOfOrders.stream().map(order -> orderMapper.toDto(order)).toList();
    } catch (Exception e) {
      log.error("Error saving order: {}", e.getMessage(), e);
      throw new RuntimeException("Failed to get orders", e);
    }
  }

  @Override
  public OrderDto getOrder(Long id) {
    Optional<Order> order;
    try {
      order = orderRepository.findById(id);
      log.info("Order {} returned at: {}", id, LocalDateTime.now());
      return orderMapper.toDto(order.get());
    } catch (Exception e) {
      log.error(
          "Error during getting order: {},: {} at: {} ", id, e.getMessage(), LocalDateTime.now());
      throw new RuntimeException("Failed to get order", e);
    }
  }

  @Override
  public OrderDto createOrder(OrderDto orderDto) {
    Order order = orderMapper.toEntity(orderDto);
    try {
      order = orderRepository.save(order);
      log.info(
          "Order {} has been successfully saved at {}", order.getOrderId(), LocalDateTime.now());
      return orderMapper.toDto(order);
    } catch (Exception e) {
      log.error("Error saving order: {}, {} at: {} ", e.getMessage(), e, LocalDateTime.now());
      throw new RuntimeException("Failed to save order", e);
    }
  }

  @Override
  public OrderDto updateOrder(OrderDto orderDtoToUpdate) {
    Long orderId = orderDtoToUpdate.getOrderId();
    OrderDto orderDtoBeingUpdated = getOrder(orderId);
    orderDtoBeingUpdated.setListOfOrderItems(orderDtoToUpdate.getListOfOrderItems());
    Order orderBeingUpdated = orderMapper.toEntity(orderDtoBeingUpdated);
    try {
      orderRepository.save(orderBeingUpdated);
      log.info(
          "Order {} has been successfully updated at {}",
          orderBeingUpdated.getOrderId(),
          LocalDateTime.now());
      return orderDtoBeingUpdated;
    } catch (Exception e) {
      log.error("Error updating order: {}, {}", orderBeingUpdated.getOrderId(), e.getMessage(), e);
      throw new RuntimeException("Failed to update order: ", e);
    }
  }

  @Override
  public ResponseEntity<ApiResponse<OrderDto>> deleteOrder(OrderDto orderDto, Long id) {
    return ResponseEntity.ok(
        new ApiResponse<>(HttpStatus.OK.value(), String.format("Order :%x deleted", id), orderDto));
  }
}
