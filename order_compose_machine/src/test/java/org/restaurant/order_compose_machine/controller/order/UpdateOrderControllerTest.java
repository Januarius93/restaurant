package org.restaurant.order_compose_machine.controller.order;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.net.URI;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.controller.OrderController;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@Import(OrderController.class)
public class UpdateOrderControllerTest extends AbstractUnitTest implements OCMUnitTest {

  @Mock private OrderServiceImpl orderService;

  @SneakyThrows
  @Test
  public void withProperOrderPayloadOrderUpdatedWithHttp200() {
    Long id = 1L;
    OrderDto orderDto = OrderDto.builder().build();
    ApiResponse<OrderDto> apiResponse =
        new ApiResponse<>(HttpStatus.OK.value(), String.format("Order :%x updated", id), orderDto);
    when(orderService.updateOrder(orderDto, id)).thenReturn(ResponseEntity.ok(apiResponse));
    ResultActions response =
        sendMockedPutRequest(new URI(String.format("/api/order/updateOrder/%x", id)), orderDto);
    response
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.message").value(String.format("Order :%x updated", id)));
  }
}
