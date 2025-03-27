package org.restaurant.order_compose_machine.service.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@Import(OrderServiceImpl.class)
public class CreateOrderServiceTest extends AbstractUnitTest implements OCMUnitTest {
  @Autowired private OrderServiceImpl orderService;

  @Test
  public void withCreateOrderServiceCallOrderIsCreatedWithHttp200() {
    OrderDto orderDto = OrderDto.builder().build();
    ResponseEntity<ApiResponse<OrderDto>> apiResponse = orderService.createOrder(orderDto);
    assertThat(apiResponse, notNullValue());
    assertThat(apiResponse.getStatusCode().value(), Matchers.is(HttpStatus.OK.value()));
    assertThat(apiResponse.getBody().getMessage(), Matchers.equalTo("Order created"));
  }
}
