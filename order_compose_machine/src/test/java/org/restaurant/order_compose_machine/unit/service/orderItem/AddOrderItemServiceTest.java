package org.restaurant.order_compose_machine.unit.service.orderItem;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.dependencies.dto.order.OrderDto;
import com.restaurant.dependencies.dto.order.OrderMapper;
import com.restaurant.dependencies.dto.order_item.OrderItemDto;
import com.restaurant.dependencies.dto.order_item.OrderItemMapper;
import com.restaurant.dependencies.enums.order.OrderItemType;
import com.restaurant.dependencies.model.order.Order;
import com.restaurant.dependencies.model.order.OrderItem;
import com.restaurant.dependencies.model.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.controller.OrderItemController;
import org.restaurant.order_compose_machine.repository.OrderItemRepository;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.restaurant.order_compose_machine.service.OrderItemServiceImpl;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;

@ExtendWith(MockitoExtension.class)
public class AddOrderItemServiceTest extends AbstractUnitTest implements OCMUnitTest {

  private static Order order;
  private static OrderDto orderDto;
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
            .orderItemId(2L)
            .itemName("Kurczaks")
            .orderItemType(OrderItemType.CUSTOM)
            .product(ProductDto.builder().productName("Kurczak po kurczakowemu").build())
            .build();
    orderItem1 =
        OrderItem.builder()
            .orderItemId(2L)
            .itemName("Kurczaks")
            .orderItemType(OrderItemType.CUSTOM)
            .product(Product.builder().productName("Kurczak po kurczakowemu").build())
            .build();
  }

  @SneakyThrows
  @Test
  public void withProperOrderItemPayloadOrderItemAddedToOrderWithHttp200() {
    orderDto.setListOfOrderItems(List.of(orderItemDto));
    order.setListOfOrderItems(new ArrayList<>(List.of(orderItem)));

    when(orderItemMapper.toEntity(orderItemDto)).thenReturn(orderItem);
    when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
    when(orderMapper.toDto(order)).thenReturn(orderDto);
    OrderDto resultOrder = orderItemService.addOrderItem(orderItemDto, 1L);

    assertThat(resultOrder.getListOfOrderItems().size(), is(1));
    assertThat(resultOrder.getListOfOrderItems().get(0).getItemName(), is("Pasta"));
  }

  @SneakyThrows
  @Test
  public void withProperOrderItemPayloadOrderItemsAddedToOrderWithHttp200() {
    orderDto.setListOfOrderItems(List.of(orderItemDto, orderItemDto1));
    order.setListOfOrderItems(new ArrayList<>(List.of(orderItem, orderItem1)));

    when(orderItemMapper.toEntity(orderItemDto)).thenReturn(orderItem);
    when(orderItemMapper.toEntity(orderItemDto1)).thenReturn(orderItem1);
    when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
    when(orderMapper.toDto(order)).thenReturn(orderDto);
    OrderDto resultOrder = orderItemService.addOrderItems(List.of(orderItemDto, orderItemDto1), 1L);

    assertThat(resultOrder.getListOfOrderItems().size(), is(2));
    assertThat(resultOrder.getListOfOrderItems().get(1).getItemName(), is("Kurczaks"));
  }
}
