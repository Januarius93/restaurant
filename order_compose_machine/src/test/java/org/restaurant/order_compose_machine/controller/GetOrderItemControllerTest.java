package org.restaurant.order_compose_machine.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@Import(OrderItemController.class)
@AutoConfigureMockMvc
public class GetOrderItemControllerTest extends AbstractUnitTest {

  @Autowired protected MockMvc mockMvc;
  @Autowired ObjectMapper objectMapper;

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
  public void withGetOrderItemAllOrderItemsAreReturnedWithHttp200() {
    Long id = 1l;
    mockMvc
        .perform(
            MockMvcRequestBuilders.get(String.format("/api/order/getOrderItem/%x", id))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value(String.format("Order item :%x", id)))
        .andReturn();
  }
}
