package org.restaurant.order_compose_machine.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.service.OrderItemServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("api/order/{orderId}/orderItem")
@RequiredArgsConstructor
public class OrderItemController {
  private static final Logger log = LoggerFactory.getLogger(OrderItemController.class);

  @Autowired private OrderItemServiceImpl orderItemService;

  @SneakyThrows
  @GetMapping(value = "/getOrderItems")
  public ResponseEntity<ApiResponse<String>> getOrderItems() {
    return orderItemService.getOrderItems();
  }

  @SneakyThrows
  @GetMapping(value = "/getOrderItem/{id}")
  public ResponseEntity<ApiResponse<String>> getOrderItem(@PathVariable Long id) {
    return orderItemService.getOrderItem(id);
  }

  @SneakyThrows
  @PostMapping(value = "/addOrderItem", consumes = "application/json")
  public ResponseEntity<ApiResponse<OrderDto>> addOrderItem(
      @Valid @RequestBody OrderItemDto orderItemDto,
      @PathVariable Long orderId,
      BindingResult bindingResult) {
    OrderDto order = orderItemService.addOrderItem(orderItemDto, orderId);
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Order item added", order));
  }

  @SneakyThrows
  @PostMapping(value = "/addOrderItems", consumes = "application/json")
  public ResponseEntity<ApiResponse<OrderDto>> addOrderItems(
      @Valid @RequestBody List<OrderItemDto> listOfOrderItems,
      @PathVariable Long orderId,
      BindingResult bindingResult) {
    OrderDto order = orderItemService.addOrderItems(listOfOrderItems, orderId);
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Order items added", order));
  }

  @SneakyThrows
  @DeleteMapping(value = "/deleteOrderItem/{orderItemId}")
  public ResponseEntity<ApiResponse<OrderDto>> deleteOrderItem(
      @PathVariable Long orderId, @PathVariable Long orderItemId) {
    OrderDto order = orderItemService.deleteOrderItem(orderId, orderItemId);
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Order item deleted", order));
  }

  @SneakyThrows
  @PutMapping(value = "/updateOrderItem/{id}", consumes = "application/json")
  public ResponseEntity<ApiResponse<OrderDto>> updateOrderItem(
      @Valid @RequestBody OrderItemDto orderItemDto,
      @PathVariable Long id,
      BindingResult bindingResult) {
    OrderDto order = orderItemService.updateOrderItem(orderItemDto, id);
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Order item updated", order));
  }
}
