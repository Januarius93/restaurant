package org.restaurant.order_compose_machine.service.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.AbstractUnitTest;
import org.restaurant.order_compose_machine.OCMUnitTest;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@Import(OrderServiceImpl.class)
public class GetOrderServiceTest extends AbstractUnitTest implements OCMUnitTest {

  @Autowired private OrderServiceImpl orderService;

  @Test
  public void withGetOrdersServiceCallAllOrdersAreReturnedWithHttp200() {
    ResponseEntity<ApiResponse<String>> apiResponse = orderService.getOrders();
    assertThat(apiResponse, notNullValue());
    assertThat(apiResponse.getStatusCode().value(), Matchers.is(HttpStatus.OK.value()));
  }

  @Test
  public void withGetOrderServiceCallOrderIsReturnedWithHttp200() {
    Long id = 1L;
    ResponseEntity<ApiResponse<String>> apiResponse = orderService.getOrder(id);
    assertThat(apiResponse, notNullValue());
    assertThat(apiResponse.getStatusCode().value(), Matchers.is(HttpStatus.OK.value()));
    assertThat(apiResponse.getBody().getMessage(), Matchers.equalTo("Order :1"));
  }
}
