package org.restaurant.order_compose_machine.unit.service.orderItem;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.controller.OrderItemController;
import org.restaurant.order_compose_machine.dto.ProductDto;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemMapper;
import org.restaurant.order_compose_machine.enums.order.OrderItemType;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.model.order.OrderItem;
import org.restaurant.order_compose_machine.model.product.Product;
import org.restaurant.order_compose_machine.repository.OrderItemRepository;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.restaurant.order_compose_machine.service.OrderItemServiceImpl;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;

@ExtendWith(MockitoExtension.class)
public class DeleteOrderItemServiceTest extends AbstractUnitTest implements OCMUnitTest {
  private static Order order, orderWithOneOrderItem;
  private static OrderDto orderDto, orderDtoWithOneOrderItem;
  private static OrderItemDto orderItemDto, orderItemDto1;
  private static OrderItem orderItem, orderItem1;
  @InjectMocks private OrderItemServiceImpl orderItemService;
  @Mock private OrderServiceImpl orderService;
  @Mock private OrderItemController orderItemController;
  @Mock private OrderItemMapper orderItemMapper;
  @Mock private OrderMapper orderMapper;
  @Mock private OrderRepository orderRepository;
  @Mock private OrderItemRepository orderItemRepository;

  @BeforeAll
  public static void beforeAll() {
    order = Order.builder().orderId(1L).build();
    orderDto = OrderDto.builder().orderId(1L).build();

    orderWithOneOrderItem = Order.builder().orderId(1L).build();
    orderDtoWithOneOrderItem = OrderDto.builder().orderId(1L).build();

    orderItemDto =
        OrderItemDto.builder()
            .orderItemId(2L)
            .itemName("Pasta")
            .orderItemType(OrderItemType.CUSTOM)
            .product(ProductDto.builder().productName("Pasta bolognese").build())
            .build();
    orderItem =
        OrderItem.builder()
            .orderItemId(2L)
            .itemName("Pasta")
            .orderItemType(OrderItemType.CUSTOM)
            .product(Product.builder().productName("Pasta bolognese").build())
            .build();

    orderItemDto1 =
        OrderItemDto.builder()
            .orderItemId(3L)
            .itemName("Kurczaks")
            .orderItemType(OrderItemType.CUSTOM)
            .product(ProductDto.builder().productName("Kurczak po kurczakowemu").build())
            .build();
    orderItem1 =
        OrderItem.builder()
            .orderItemId(3L)
            .itemName("Kurczaks")
            .orderItemType(OrderItemType.CUSTOM)
            .product(Product.builder().productName("Kurczak po kurczakowemu").build())
            .build();

    orderDto.setListOfOrderItems(List.of(orderItemDto, orderItemDto1));
    order.setListOfOrderItems(new ArrayList<>(List.of(orderItem, orderItem1)));

    orderWithOneOrderItem.setListOfOrderItems(List.of(orderItem));
    orderDtoWithOneOrderItem.setListOfOrderItems(List.of(orderItemDto));
  }

  @Test
  public void withDeleteOrderItemServiceCallOrderItemIsDeletedWithHttp200() {
    when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
    when(orderMapper.toDto(any(Order.class)))
        .thenAnswer(
            invocation -> {
              Order updatedOrder = invocation.getArgument(0);
              List<OrderItemDto> itemDtos =
                  updatedOrder.getListOfOrderItems().stream()
                      .map(orderItemMapper::toDto)
                      .collect(Collectors.toList());
              OrderDto dto = OrderDto.builder().orderId(updatedOrder.getOrderId()).build();
              dto.setListOfOrderItems(itemDtos);
              return dto;
            });
    when(orderItemMapper.toDto(orderItem1)).thenReturn(orderItemDto1);

    OrderDto resultOrder = orderItemService.deleteOrderItem(1L, 2L);

    assertThat(resultOrder.getListOfOrderItems().size(), is(1));
    assertThat(resultOrder.getListOfOrderItems().get(0).getOrderItemId(), is(3L));
  }
}
