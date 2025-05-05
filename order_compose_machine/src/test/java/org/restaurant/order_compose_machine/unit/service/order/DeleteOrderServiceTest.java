package org.restaurant.order_compose_machine.unit.service.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.dependencies.dto.order.OrderDto;
import com.restaurant.dependencies.dto.order.OrderMapper;
import com.restaurant.dependencies.dto.order_item.OrderItemDto;
import com.restaurant.dependencies.model.order.Order;
import com.restaurant.dependencies.model.order.OrderItem;
import com.restaurant.dependencies.model.product.Product;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;

@ExtendWith(MockitoExtension.class)
public class DeleteOrderServiceTest extends AbstractUnitTest implements OCMUnitTest {
  @InjectMocks private OrderServiceImpl orderService;
  @Mock private OrderRepository orderRepository;
  @Mock private OrderMapper orderMapper;

  @Test
  public void withDeleteOrderServiceCallOrderIsDeletedWithHttp200() {
    Long orderId = 1L;

    Order existingOrder = new Order();
    existingOrder.setOrderId(orderId);
    OrderItem exisitingOrderItem = new OrderItem();
    exisitingOrderItem.setItemName("Pizzunia");

    Product existingProduct = new Product();
    existingProduct.setProductName("Pizzunia Product");
    exisitingOrderItem.setProduct(existingProduct);
    existingOrder.setListOfOrderItems(List.of(exisitingOrderItem));

    OrderDto existingOrderDto = new OrderDto();
    existingOrderDto.setOrderId(orderId);
    OrderItemDto existingOrderItemDto = new OrderItemDto();
    existingOrderItemDto.setItemName("Pizzunia");

    ProductDto existingProductDto = new ProductDto();
    existingProductDto.setProductName("Pizzunia Product");
    exisitingOrderItem.setProduct(existingProduct);
    existingOrderDto.setListOfOrderItems(List.of(existingOrderItemDto));

    when(orderRepository.findById(orderId))
        .thenReturn(Optional.of(existingOrder)); // Finding the order
    when(orderMapper.toDto(existingOrder)).thenReturn(existingOrderDto);

    OrderDto response = orderService.deleteOrder(1L);

    verify(orderRepository).delete(existingOrder);
    assertThat(response, notNullValue());
    assertThat(response.getOrderId(), is(orderId));
  }
}
