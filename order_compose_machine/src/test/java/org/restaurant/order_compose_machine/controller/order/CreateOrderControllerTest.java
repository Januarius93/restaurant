package org.restaurant.order_compose_machine.controller.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

import java.util.List;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.controller.OrderController;
import org.restaurant.order_compose_machine.dto.ProductDto;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.model.order.OrderItem;
import org.restaurant.order_compose_machine.model.product.Product;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CreateOrderControllerTest extends AbstractUnitTest implements OCMUnitTest {

  @Mock private OrderServiceImpl orderService;
  @InjectMocks private OrderController orderController;
  @Mock private OrderRepository orderRepository;
  @Mock private OrderMapper orderMapper;

  @SneakyThrows
  @Test
  public void withProperOrderPayloadOrderCanBeCreatedWithHttp200() {
    Long orderId = 1L;

    Order order1 = new Order();
    order1.setOrderId(orderId);

    OrderItem orderItem = new OrderItem();
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
