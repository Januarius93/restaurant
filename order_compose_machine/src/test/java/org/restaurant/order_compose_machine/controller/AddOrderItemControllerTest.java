package org.restaurant.order_compose_machine.controller;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Import(OrderItemController.class)
@AutoConfigureMockMvc
public class AddOrderItemControllerTest extends AbstractUnitTest {

  @Autowired protected MockMvc mockMvc;
  @Autowired ObjectMapper objectMapper;
  @SneakyThrows
  @Test
  public void withProperOrderItemPayloadOrderItemCanBeAddedToOrderWithHttp200() {
    OrderItemDto orderItemDto =
        OrderItemDto.builder().itemName("Pizza").quantity(2).price(23.0).build();
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/order/addOrderItem")
                .content(objectMapper.writeValueAsString(orderItemDto))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(
            jsonPath("$.message").value("Order item added")) //
        .andReturn();
  }

  @SneakyThrows
  @Test
  public void withEmptyItemNameReturn400() {
    OrderItemDto orderItemDto =
            OrderItemDto.builder().build();
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/order/addOrderItem")
                .content(objectMapper.writeValueAsString(orderItemDto))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Validation failed"))
        .andExpect(jsonPath("$.data['addOrderItem.orderItemDto.itemName']").value("Item name can not be blank"))
        .andReturn();
  }
}
