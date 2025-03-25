package org.restaurant.order_compose_machine.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Import(OrderController.class)
@AutoConfigureMockMvc
public class OrderControllerTest extends AbstractUnitTest {

  @Autowired protected MockMvc mockMvc;
  @Autowired ObjectMapper objectMapper;

  //  @SneakyThrows
  //  @Test
  //  @Disabled
  //  public void withProperOrderPayloadOrderShouldReturnSuccessWithHttp200() {
  //    List<OrderItemDto> listOfOrderItemsDto =
  //        List.of(
  //            OrderItemDto.builder().itemName("Pizza").quantity(2).price(23.0).build(),
  //            OrderItemDto.builder().itemName("Cola").quantity(1).price(8.0).build());
  //    OrderDto orderDto = OrderDto.builder().id(12).listOfOrderItems(listOfOrderItemsDto).build();
  //
  //    mockMvc
  //        .perform(
  //            MockMvcRequestBuilders.post("/order/proceed")
  //                .content(String.valueOf(orderDto))
  //                .contentType(MediaType.APPLICATION_JSON))
  //        .andExpect(status().isOk())
  //        .andExpect(content().json("order placed"))
  //        .andReturn();
  //  }
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
            jsonPath("$.message").value("order item added")) //
        .andReturn();
  }
}
