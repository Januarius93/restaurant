package org.restaurant.order_compose_machine.unit.controller.orderItem;

import com.restaurant.dependencies.dto.order_item.OrderItemMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.controller.OrderItemController;
import org.restaurant.order_compose_machine.service.OrderItemServiceImpl;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;

@ExtendWith(MockitoExtension.class)
public class AddOrderItemControllerUnitTest extends AbstractUnitTest implements OCMUnitTest {

  @Mock private OrderItemServiceImpl orderItemService;
  @Mock private OrderServiceImpl orderService;
  @InjectMocks private OrderItemController orderItemController;
  @Mock private OrderItemMapper orderItemMapper;

  //  @SneakyThrows
  //  @Test
  //  public void withEmptyItemNameReturn400() {
  //    OrderItemDto orderItemDto = OrderItemDto.builder().build();
  //    mockMvc
  //        .perform(
  //            MockMvcRequestBuilders.post("/api/order/addOrderItem")
  //                .content(objectMapper.writeValueAsString(orderItemDto))
  //                .contentType(MediaType.APPLICATION_JSON))
  //        .andExpect(status().isBadRequest())
  //        .andExpect(jsonPath("$.message").value("Validation failed"))
  //        .andExpect(
  //            jsonPath("$.data['addOrderItem.orderItemDto.itemName']")
  //                .value("Item name can not be blank"))
  //        .andReturn();
  //  }
}
