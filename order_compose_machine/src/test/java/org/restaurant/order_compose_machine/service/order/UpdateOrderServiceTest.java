package org.restaurant.order_compose_machine.service.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.model.order.OrderItem;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UpdateOrderServiceTest extends AbstractUnitTest implements OCMUnitTest {
  @InjectMocks private OrderServiceImpl orderService;
  @Mock private OrderRepository orderRepository;
  @Mock private OrderMapper orderMapper;

  @Test
  public void withUpdateOrderServiceCallOrderIsUpdatedWithHttp200() {
    // GIVEN order already stored in database
    Long orderId = 1L;
    Order orderAlreadyStoredInDatabase = new Order();
    orderAlreadyStoredInDatabase.setOrderId(orderId);
    // with some data init
    OrderItem orderItemAlreadyStoredInDatabase = new OrderItem();
    orderItemAlreadyStoredInDatabase.setItemName("Pizzunia");
    orderAlreadyStoredInDatabase.setListOfOrderItems(List.of(orderItemAlreadyStoredInDatabase));

    // GIVEN orderdto already stored in database
    OrderDto orderDtoAlreadyStoredInDatabase = new OrderDto();
    orderDtoAlreadyStoredInDatabase.setOrderId(orderId);

    // GIVEN order update to be stored in database
    Long orderId1 = 1L;
    Order orderToBeStoredInDatabase = new Order();
    orderAlreadyStoredInDatabase.setOrderId(orderId1);
    // with some data init
    OrderItem orderItemToBeStoredInDatabase = new OrderItem();
    orderItemToBeStoredInDatabase.setItemName("Pizzunia UPDATE");
    orderToBeStoredInDatabase.setListOfOrderItems(List.of(orderItemToBeStoredInDatabase));

    // GIVEN orderdto to be stored in database
    OrderDto orderDtoToBeStoredInDatabase = new OrderDto();
    orderDtoToBeStoredInDatabase.setOrderId(orderId);

    when(orderRepository.findById(orderId)).thenReturn(Optional.of(orderAlreadyStoredInDatabase));
    when(orderMapper.toDto(orderAlreadyStoredInDatabase))
        .thenReturn(orderDtoAlreadyStoredInDatabase);

    when(orderRepository.save(any(Order.class))).thenReturn(orderToBeStoredInDatabase);
    when(orderMapper.toDto(orderToBeStoredInDatabase)).thenReturn(orderDtoToBeStoredInDatabase);

    OrderDto responseOrder = orderService.updateOrder(orderDtoToBeStoredInDatabase);
    assertThat(responseOrder, notNullValue());
  }
}
