package org.restaurant.order_compose_machine.service.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.restaurant.order_compose_machine.dto.ProductDto;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(OrderServiceImpl.class)
public class CreateOrderServiceTest extends AbstractUnitTest implements OCMUnitTest {
  @Autowired private OrderServiceImpl orderService;

  @Test
  public void withCreateOrderServiceCallOrderIsCreatedWithHttp200() {
    OrderDto orderDto =
        OrderDto.builder()
            .listOfOrderItems(
                List.of(OrderItemDto.builder().product(ProductDto.builder().build()).build()))
            .build();
    OrderDto receivedOrderDto = orderService.createOrder(orderDto);
    assertThat(receivedOrderDto, notNullValue());
  }
}
