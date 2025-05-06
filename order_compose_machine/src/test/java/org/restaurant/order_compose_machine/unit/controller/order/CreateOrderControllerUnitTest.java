package org.restaurant.order_compose_machine.unit.controller.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

import com.restaurant.dependencies.config.ApiResponse;
import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.dependencies.dto.order.OrderDto;
import com.restaurant.dependencies.dto.order_item.OrderItemDto;
import com.restaurant.dependencies.model.order.Order;
import com.restaurant.dependencies.model.order.OrderItem;
import com.restaurant.dependencies.model.product.Product;
import java.util.List;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.controller.OrderController;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CreateOrderControllerUnitTest extends AbstractUnitTest implements OCMUnitTest {

  @Mock private OrderServiceImpl orderService;
  @InjectMocks private OrderController orderController;

  @SneakyThrows
  @Test
  public void withProperOrderPayloadOrderCanBeCreatedWithHttp200() {
    Long orderId = 1L;

    Order order1 = new Order();
    order1.setOrderId(orderId);

    OrderItem orderItem = OrderItem.builder().build();
    orderItem.setItemName("Pizza");

    Product product = new Product();
    product.setProductName("Pizza Product");

    orderItem.setProduct(product);
    order1.setListOfOrderItems(List.of(orderItem));

    OrderDto orderDto = new OrderDto();
    orderDto.setOrderId(orderId);

    OrderItemDto orderItemDto = new OrderItemDto();
    orderItemDto.setItemName("Pizza");

    ProductDto productDto = new ProductDto();
    productDto.setProductName("Pizza Product");

    orderItemDto.setProduct(productDto);
    orderDto.setListOfOrderItems(List.of(orderItemDto));

    when(orderService.createOrder(orderDto)).thenReturn(orderDto);

    ResponseEntity<ApiResponse<OrderDto>> responseOrder = orderController.createOrder(orderDto);

    assertThat(responseOrder, notNullValue());
    assertThat(responseOrder.getStatusCode(), Matchers.is(HttpStatus.OK));
    assertThat(responseOrder.getBody().getData().getOrderId(), Matchers.is(orderId));
  }
}
