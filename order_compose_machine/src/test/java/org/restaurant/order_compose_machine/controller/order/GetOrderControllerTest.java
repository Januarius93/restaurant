package org.restaurant.order_compose_machine.controller.order;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@SpringBootTest
// @Import(OrderItemController.class)
public class GetOrderControllerTest extends AbstractUnitTest implements OCMUnitTest {

  @SneakyThrows
  @Test
  public void withGetOrderItemsAllOrdersAreReturnedWithHttp200() {
    ResultActions response = sendMockedGetRequest(new URI("/api/order/getOrders"));
    response.andExpect(MockMvcResultMatchers.status().isOk());
  }
}
