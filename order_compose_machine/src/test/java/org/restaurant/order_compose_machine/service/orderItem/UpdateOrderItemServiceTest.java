package org.restaurant.order_compose_machine.service.orderItem;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.service.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@Import(OrderItemServiceImpl.class)
public class UpdateOrderItemServiceTest extends AbstractUnitTest implements OCMUnitTest {
  @Autowired private OrderItemServiceImpl orderItemService;

  @Test
  public void withUpdateOrderItemServiceCallOrderItemIsUpdatedWithHttp200() {
    Long id = 1L;
    OrderItemDto orderItemDto = OrderItemDto.builder().build();
    ResponseEntity<ApiResponse<OrderItemDto>> apiResponse =
        orderItemService.updateOrderItem(orderItemDto, id);
    assertThat(apiResponse, notNullValue());
    assertThat(apiResponse.getStatusCode().value(), Matchers.is(HttpStatus.OK.value()));
    assertThat(
        apiResponse.getBody().getMessage(),
        Matchers.equalTo(String.format("Order item :%x updated", id)));
  }
}
