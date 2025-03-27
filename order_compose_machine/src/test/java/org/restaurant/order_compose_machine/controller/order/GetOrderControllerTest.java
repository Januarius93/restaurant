package org.restaurant.order_compose_machine.controller.order;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.restaurant.order_compose_machine.controller.OrderController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@Import(OrderController.class)
public class GetOrderControllerTest extends AbstractUnitTest implements OCMUnitTest {

  @SneakyThrows
  @Test
  public void withGetOrderItemsAllOrdersAreReturnedWithHttp200() {
    ResultActions response = sendMockedGetRequest(new URI("/api/order/getOrders"));
    response
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.message").value("All orders returned"));
  }

  @SneakyThrows
  @Test
  public void withGetOrderOrderIsReturnedWithHttp200() {
    Long id = 1L;
    ResultActions response =
        sendMockedGetRequest(new URI(String.format("/api/order/getOrder/%x", id)));
    response
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.message").value(String.format("Order :%x", id)));
  }
}
