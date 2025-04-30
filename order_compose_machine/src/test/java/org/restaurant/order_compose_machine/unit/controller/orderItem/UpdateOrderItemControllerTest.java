package org.restaurant.order_compose_machine.unit.controller.orderItem;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.controller.OrderItemController;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@Import(OrderItemController.class)
@Disabled
public class UpdateOrderItemControllerTest extends AbstractUnitTest {

  @SneakyThrows
  @Test
  public void withProperUpdateOrderItemPayloadOrderItemUpdatedWithHttp200() {
    Long id = 1L;
    OrderItemDto orderItemDto =
        OrderItemDto.builder().itemName("Pizza").quantity(2).price(23.0).build();
    mockMvc
        .perform(
            MockMvcRequestBuilders.put(String.format("/api/order/updateOrderItem/%x", id))
                .content(objectMapper.writeValueAsString(orderItemDto))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value(String.format("Order item :%x updated", id))) //
        .andReturn();
  }
}
