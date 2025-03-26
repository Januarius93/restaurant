package org.restaurant.order_compose_machine.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.service.OrderItemServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderItemController {
  private static final Logger log = LoggerFactory.getLogger(OrderItemController.class);

  @Autowired private OrderItemServiceImpl orderItemService;

  @Autowired private OrderMapper orderMapper;

  @SneakyThrows
  @PostMapping(value = "/proceed", consumes = "application/json")
  public @ResponseBody ApiResponse<OrderDto> proceedWithOrder(
      @RequestBody @Valid OrderDto orderDto) {
    return orderItemService.proceedWithOrder(orderDto);
  }

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
  public ResponseEntity<ApiResponse<OrderItemDto>> addOrderItem(
      @Valid @RequestBody OrderItemDto orderItemDto, BindingResult bindingResult) {
    return orderItemService.addOrderItem(orderItemDto);
  }

  @SneakyThrows
  @DeleteMapping(value = "/deleteOrderItem/{id}", consumes = "application/json")
  public ResponseEntity<ApiResponse<OrderItemDto>> deleteOrderItem(
      @Valid @RequestBody OrderItemDto orderItemDto,
      @PathVariable Long id,
      BindingResult bindingResult) {
    return orderItemService.deleteOrderItem(orderItemDto, id);
  }

  @SneakyThrows
  @PutMapping(value = "/updateOrderItem/{id}", consumes = "application/json")
  public ResponseEntity<ApiResponse<OrderItemDto>> updateOrderItem(
      @Valid @RequestBody OrderItemDto orderItemDto,
      @PathVariable Long id,
      BindingResult bindingResult) {
    return orderItemService.updateOrderItem(orderItemDto, id);
  }
}
