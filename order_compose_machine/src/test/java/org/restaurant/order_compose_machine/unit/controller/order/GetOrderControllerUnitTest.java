package org.restaurant.order_compose_machine.unit.controller.order;

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
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.controller.OrderController;
import org.restaurant.order_compose_machine.dto.ProductDto;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.model.order.OrderItem;
import org.restaurant.order_compose_machine.model.product.Product;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class GetOrderControllerUnitTest extends AbstractUnitTest implements OCMUnitTest {
  @Mock private OrderServiceImpl orderService;
  @InjectMocks private OrderController orderController;

  @SneakyThrows
  @Test
  public void withGetOrderItemsAllOrdersAreReturnedWithHttp200() {
    Long orderId1 = 1L;
    Long orderId2 = 2L;

    Order order1 = new Order();
    order1.setOrderId(orderId1);
    Order order2 = new Order();
    order2.setOrderId(orderId2);

    OrderItem orderItem1 = new OrderItem();
    orderItem1.setItemName("Pizza");
    OrderItem orderItem2 = new OrderItem();
    orderItem2.setItemName("Pizza");

    Product product = new Product();
    product.setProductName("Pizza Product");

    orderItem1.setProduct(product);
    order1.setListOfOrderItems(List.of(orderItem1));

    orderItem2.setProduct(product);
    order2.setListOfOrderItems(List.of(orderItem2));

    OrderDto orderDto1 = new OrderDto();
    orderDto1.setOrderId(orderId1);
    OrderDto orderDto2 = new OrderDto();
    orderDto2.setOrderId(orderId2);

    OrderItemDto orderItemDto1 = new OrderItemDto();
    orderItemDto1.setItemName("Pizza");
    OrderItemDto orderItemDto2 = new OrderItemDto();
    orderItemDto2.setItemName("Pizza");

    ProductDto productDto = new ProductDto();
    productDto.setProductName("Pizza Product");

    orderItemDto1.setProduct(productDto);
    orderDto1.setListOfOrderItems(List.of(orderItemDto1));

    orderItemDto2.setProduct(productDto);
    orderDto2.setListOfOrderItems(List.of(orderItemDto2));

    when(orderService.getOrders()).thenReturn(List.of(orderDto1, orderDto2));

    ResponseEntity<ApiResponse<List<OrderDto>>> responseOrder = orderController.getOrders();

    assertThat(responseOrder, notNullValue());
    assertThat(responseOrder.getStatusCode(), Matchers.is(HttpStatus.OK));
    assertThat(responseOrder.getBody().getData().get(0).getOrderId(), Matchers.is(orderId1));
  }

  @SneakyThrows
  @Test
  public void withGetOrderOrderIsReturnedWithHttp200() {
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

    when(orderService.getOrder(orderId)).thenReturn(orderDto);

    ResponseEntity<ApiResponse<OrderDto>> responseOrder = orderController.getOrder(orderId);

    assertThat(responseOrder, notNullValue());
    assertThat(responseOrder.getStatusCode(), Matchers.is(HttpStatus.OK));
    assertThat(responseOrder.getBody().getData().getOrderId(), Matchers.is(orderId));
  }
}
