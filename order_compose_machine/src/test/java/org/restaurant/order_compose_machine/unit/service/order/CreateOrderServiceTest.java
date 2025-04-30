package org.restaurant.order_compose_machine.unit.service.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.dto.ProductDto;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.model.order.OrderItem;
import org.restaurant.order_compose_machine.model.product.Product;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;

@ExtendWith(MockitoExtension.class)
public class CreateOrderServiceTest extends AbstractUnitTest implements OCMUnitTest {
  @InjectMocks private OrderServiceImpl orderService;
  @Mock private OrderRepository orderRepository;
  @Mock private OrderMapper orderMapper;

  @Test
  public void withCreateOrderServiceCallOrderIsCreatedWithHttp200() {
    Order order1 = new Order();
    order1.setOrderId(1L);

    OrderItem orderItem1 = new OrderItem();
    orderItem1.setItemName("Pizza");

    Product product = new Product();
    product.setProductName("Pizza Product");

    orderItem1.setProduct(product);
    order1.setListOfOrderItems(List.of(orderItem1));

    OrderDto orderDto1 = new OrderDto();
    orderDto1.setOrderId(1L);

    OrderItemDto orderItemDto1 = new OrderItemDto();
    orderItemDto1.setItemName("Pizza");

    ProductDto productDto = new ProductDto();
    productDto.setProductName("Pizza Product");

    orderItemDto1.setProduct(productDto);
    orderDto1.setListOfOrderItems(List.of(orderItemDto1));

    when(orderMapper.toEntity(orderDto1)).thenReturn(order1);
    when(orderRepository.save(any(Order.class))).thenReturn(order1);
    when(orderMapper.toDto(order1)).thenReturn(orderDto1);

    OrderDto receivedOrderDto = orderService.createOrder(orderDto1);

    verify(orderRepository).save(order1);
    assertThat(receivedOrderDto, notNullValue());
  }
}
