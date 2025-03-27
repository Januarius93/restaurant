package org.restaurant.order_compose_machine.controller.orderItem;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.controller.OrderItemController;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@Import(OrderItemController.class)
public class AddOrderItemControllerTest extends AbstractUnitTest {

  @SneakyThrows
  @Test
  public void withProperOrderItemPayloadOrderItemAddedToOrderWithHttp200() {
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
