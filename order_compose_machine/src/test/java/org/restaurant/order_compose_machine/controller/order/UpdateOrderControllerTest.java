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
public class UpdateOrderControllerTest extends AbstractUnitTest implements OCMUnitTest {

  @SneakyThrows
  @Test
  public void withProperOrderPayloadOrderUpdatedWithHttp200() {
    Long id = 1L;
    OrderDto orderDto = OrderDto.builder().build();
    ResultActions response =
        sendMockedPutRequest(new URI(String.format("/api/order/updateOrder/%x", id)), orderDto);
    response
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.message").value(String.format("Order :%x updated", id)));
  }
}
