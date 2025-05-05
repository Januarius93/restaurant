package org.restaurant.order_compose_machine.unit.service.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.dependencies.dto.order.OrderDto;
import com.restaurant.dependencies.dto.order.OrderMapper;
import com.restaurant.dependencies.dto.order_item.OrderItemDto;
import com.restaurant.dependencies.model.order.Order;
import com.restaurant.dependencies.model.order.OrderItem;
import java.util.List;
import java.util.Optional;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;

@ExtendWith(MockitoExtension.class)
public class GetOrderServiceTest implements OCMUnitTest {

  @InjectMocks private OrderServiceImpl orderService;
  @Mock private OrderRepository orderRepository;
  @Mock private OrderMapper orderMapper;

  @Test
  public void withGetOrdersServiceCallAllOrdersAreReturnedWithHttp200() {
    Order order1 = new Order();
    order1.setOrderId(1L);
    Order order2 = new Order();
    order2.setOrderId(2L);

    OrderItem orderItem1 = new OrderItem();
    orderItem1.setItemName("Pizza");
    OrderItem orderItem2 = new OrderItem();
    orderItem2.setItemName("Burger");

    when(orderRepository.findAll()).thenReturn(List.of(order1, order2));

    OrderDto orderDto1 = new OrderDto();
    orderDto1.setOrderId(1L);

    OrderDto orderDto2 = new OrderDto();
    orderDto2.setOrderId(2L);

    OrderItemDto orderItemDto1 = new OrderItemDto();
    orderItemDto1.setItemName("Pizza");
    OrderItemDto orderItemDto2 = new OrderItemDto();
    orderItemDto2.setItemName("Burger");

    ProductDto productDto = new ProductDto();
    productDto.setProductName("Pizza Product");

    when(orderMapper.toDto(order1)).thenReturn(orderDto1);
    when(orderMapper.toDto(order2)).thenReturn(orderDto2);

    List<OrderDto> orderDtoList = orderService.getOrders();

    verify(orderRepository).findAll();
    assertThat(orderDtoList, notNullValue());
    assertThat(orderDtoList.size(), Matchers.is(2));
  }

  @Test
  public void withGetOrderServiceCallOrderIsReturnedWithHttp200() {
    Long orderId = 1L;
    Order order = new Order();
    order.setOrderId(orderId);
    OrderDto orderDto = new OrderDto();
    orderDto.setOrderId(orderId);

    when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
    OrderDto orderDto1 = new OrderDto();
    orderDto1.setOrderId(1L);

    OrderDto orderDto2 = new OrderDto();
    orderDto2.setOrderId(2L);
    OrderItemDto orderItemDto1 = new OrderItemDto();
    orderItemDto1.setItemName("Pizza");
    OrderItemDto orderItemDto2 = new OrderItemDto();
    orderItemDto2.setItemName("Burger");

    ProductDto productDto = new ProductDto();
    productDto.setProductName("Pizza Product");

    when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
    when(orderMapper.toDto(order)).thenReturn(orderDto);
    Long id = 1L;

    OrderDto responseOrder = orderService.getOrder(id);
    assertThat(responseOrder, notNullValue());
  }
}
