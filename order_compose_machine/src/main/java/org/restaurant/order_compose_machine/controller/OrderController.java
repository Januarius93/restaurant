package org.restaurant.order_compose_machine.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
  private static final Logger log = LoggerFactory.getLogger(OrderController.class);

  @Autowired private OrderServiceImpl orderService;

  @Autowired private OrderMapper orderMapper;

  @SneakyThrows
  @PostMapping(value = "/proceed", consumes = "application/json")
  public @ResponseBody ApiResponse<OrderDto> proceedWithOrder(
      @RequestBody @Valid OrderDto orderDto) {
    return orderService.proceedWithOrder(orderDto);
  }
}
