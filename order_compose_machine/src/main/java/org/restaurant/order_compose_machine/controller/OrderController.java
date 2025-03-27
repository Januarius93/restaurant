package org.restaurant.order_compose_machine.controller;

import lombok.RequiredArgsConstructor;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.Dto;
import org.restaurant.order_compose_machine.service.OrderService;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
