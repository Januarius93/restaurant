package org.restaurant.order_compose_machine.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.Dto;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {
  @Autowired OrderServiceImpl orderService;

  @GetMapping("/getOrders")
  public ResponseEntity<ApiResponse<String>> getOrders() {
    return orderService.getOrders();
  }

  @GetMapping("/getOrder/{id}")
  public ResponseEntity<ApiResponse<String>> getOrder(@PathVariable Long id) {
    return orderService.getOrder(id);
  }

  @PostMapping(value = "/createOrder", consumes = "application/json")
  public @ResponseBody ResponseEntity<ApiResponse<OrderDto>> createOrder(@Valid @RequestBody OrderDto orderDto) {
    return orderService.createOrder(orderDto);
  }

  @PutMapping(value = "/updateOrder/{id}", consumes = "application/json")
  public @ResponseBody ResponseEntity<ApiResponse<OrderDto>> createOrder(@Valid @RequestBody OrderDto orderDto, @PathVariable Long id) {
    return orderService.updateOrder(orderDto,id);
  }

  @DeleteMapping(value = "/deleteOrder/{id}", consumes = "application/json")
  public @ResponseBody ResponseEntity<ApiResponse<OrderDto>> deleteOrder(@Valid @RequestBody OrderDto orderDto, @PathVariable Long id) {
    return orderService.deleteOrder(orderDto,id);
  }
}
