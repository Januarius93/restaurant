package org.restaurant.order_compose_machine.unit.controller.orderItem;

import com.beust.ah.A;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.controller.OrderController;
import org.restaurant.order_compose_machine.controller.OrderItemController;
import org.restaurant.order_compose_machine.dto.ProductDto;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemMapper;
import org.restaurant.order_compose_machine.enums.order.OrderItemType;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.model.order.OrderItem;
import org.restaurant.order_compose_machine.model.product.Product;
import org.restaurant.order_compose_machine.service.OrderItemService;
import org.restaurant.order_compose_machine.service.OrderItemServiceImpl;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
