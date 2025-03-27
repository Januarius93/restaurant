package org.restaurant.order_compose_machine.controller.orderItem;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.controller.OrderItemController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@Import(OrderItemController.class)
public class GetOrderItemControllerTest extends AbstractUnitTest {

  @SneakyThrows
  @Test
  public void withGetOrderItemsAllOrderItemsAreReturnedWithHttp200() {
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/order/getOrderItems")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("All order items returned"))
        .andReturn();
  }

  @SneakyThrows
  @Test
  public void withGetOrderItemOrderItemIsReturnedWithHttp200() {
    Long id = 1L;
    mockMvc
        .perform(
            MockMvcRequestBuilders.get(String.format("/api/order/getOrderItem/%x", id))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value(String.format("Order item :%x", id)))
        .andReturn();
  }
}
