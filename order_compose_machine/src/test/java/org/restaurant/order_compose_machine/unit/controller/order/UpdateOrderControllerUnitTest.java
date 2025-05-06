package org.restaurant.order_compose_machine.unit.controller.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.dependencies.dto.order.OrderDto;
import com.restaurant.dependencies.dto.order_item.OrderItemDto;
import com.restaurant.dependencies.model.order.Order;
import com.restaurant.dependencies.model.order.OrderItem;
import com.restaurant.dependencies.model.product.Product;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.restaurant.dependencies.config.ApiResponse;
import org.restaurant.order_compose_machine.controller.OrderController;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class UpdateOrderControllerUnitTest extends AbstractUnitTest implements OCMUnitTest {

  @InjectMocks OrderController orderController;
  @Mock private OrderServiceImpl orderService;

  @SneakyThrows
  @Test
  public void withProperOrderPayloadOrderUpdatedWithHttp200() {
    Long orderId = 1L;

    // Existing order setup
    Order existingOrder = new Order();
    existingOrder.setOrderId(orderId);
    OrderItem existingOrderItem = new OrderItem();
    existingOrderItem.setItemName("Pizzunia");

    Product existingProduct = new Product();
    existingProduct.setProductName("Pizzunia Product");
    existingOrderItem.setProduct(existingProduct);
    existingOrder.setListOfOrderItems(List.of(existingOrderItem));

    // Existing OrderDto setup
    OrderDto existingOrderDto = new OrderDto();
    existingOrderDto.setOrderId(orderId);
    OrderItemDto existingOrderItemDto = new OrderItemDto();
    existingOrderItemDto.setItemName("Pizzunia");
    existingOrderDto.setListOfOrderItems(List.of(existingOrderItemDto));

    // Updated order setup
    Order updatedOrder = new Order();
    updatedOrder.setOrderId(orderId);
    OrderItem updatedItem = new OrderItem();
    updatedItem.setItemName("Pizzunia UPDATE");

    Product updatedProduct = new Product();
    updatedProduct.setProductName("Pizzunia Product UPDATE");
    updatedItem.setProduct(updatedProduct);
    updatedOrder.setListOfOrderItems(List.of(updatedItem));

    // Updated OrderDto setup
    OrderDto updatedOrderDto = new OrderDto();
    updatedOrderDto.setOrderId(orderId);
    OrderItemDto updatedOrderItemDto = new OrderItemDto();
    updatedOrderItemDto.setItemName("Pizzunia Product UPDATE");
    updatedOrderItemDto.setProduct(new ProductDto());
    updatedOrderDto.setListOfOrderItems(List.of(updatedOrderItemDto));

    when(orderService.updateOrder(updatedOrderDto, orderId)).thenReturn(updatedOrderDto);
    ResponseEntity<ApiResponse<OrderDto>> responseOrder =
        orderController.updateOrder(updatedOrderDto, orderId);
    verify(orderService).updateOrder(updatedOrderDto, orderId);
    assertThat(
        responseOrder.getBody().getData().getListOfOrderItems().stream()
            .findFirst()
            .get()
            .getItemName(),
        is("Pizzunia Product UPDATE"));
  }
}
