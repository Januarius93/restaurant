package org.restaurant.order_compose_machine.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
  public ResponseEntity<ApiResponse<List<OrderDto>>> getOrders() {
    List<OrderDto> listOfOrders = orderService.getOrders();
    return ResponseEntity.ok(
        new ApiResponse<>(HttpStatus.OK.value(), "All orders returned", listOfOrders));
  }

  @GetMapping("/getOrder/{id}")
  public ResponseEntity<ApiResponse<OrderDto>> getOrder(@PathVariable Long id) {
    OrderDto order = orderService.getOrder(id);
    return ResponseEntity.ok(
        new ApiResponse<>(HttpStatus.OK.value(), String.format("Order: %x", id), order));
  }

  @PostMapping(value = "/createOrder", consumes = "application/json")
  public @ResponseBody ResponseEntity<ApiResponse<OrderDto>> createOrder(
      @Valid @RequestBody OrderDto orderDto) {
    OrderDto orderDtoResponse = orderService.createOrder(orderDto);
    return ResponseEntity.ok(
        new ApiResponse<>(HttpStatus.OK.value(), "Order created", orderDtoResponse));
  }

  @PutMapping(value = "/updateOrder/{id}", consumes = "application/json")
  public @ResponseBody ResponseEntity<ApiResponse<OrderDto>> updateOrder(
      @Valid @RequestBody OrderDto orderDto, @PathVariable Long id) {
    return orderService.updateOrder(orderDto, id);
  }

  @DeleteMapping(value = "/deleteOrder/{id}", consumes = "application/json")
  public @ResponseBody ResponseEntity<ApiResponse<OrderDto>> deleteOrder(
      @Valid @RequestBody OrderDto orderDto, @PathVariable Long id) {
    return orderService.deleteOrder(orderDto, id);
  }
}
