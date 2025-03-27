package org.restaurant.order_compose_machine.controller.order;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.net.URI;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.restaurant.order_compose_machine.controller.OrderController;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@Import(OrderController.class)
public class CreateOrderControllerTest extends AbstractUnitTest implements OCMUnitTest {

  @SneakyThrows
  @Test
  public void withProperOrderPayloadOrderCanBeCreatedWithHttp200() {
    OrderDto orderDto = OrderDto.builder().build();
    ResultActions response = sendMockedPostRequest(new URI("/api/order/createOrder"), orderDto);
    response
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.message").value("Order created"));
  }
}
