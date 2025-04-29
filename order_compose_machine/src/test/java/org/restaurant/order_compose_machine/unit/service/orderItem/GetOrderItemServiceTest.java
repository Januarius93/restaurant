package org.restaurant.order_compose_machine.unit.service.orderItem;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.restaurant.order_compose_machine.service.OrderItemServiceImpl;
import org.restaurant.order_compose_machine.unit.AbstractUnitTest;
import org.restaurant.order_compose_machine.unit.OCMUnitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
@Import(OrderItemServiceImpl.class)
public class GetOrderItemServiceTest extends AbstractUnitTest implements OCMUnitTest {

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @Test
    public void withGetOrderItemsServiceCallAllOrderItemsAreReturnedWithHttp200() {
        ResponseEntity<ApiResponse<String>> apiResponse = orderItemService.getOrderItems();
        assertThat(apiResponse, notNullValue());
        assertThat(apiResponse.getStatusCode().value(), Matchers.is(HttpStatus.OK.value()));
    }

    @Test
    public void withGetOrderItemServiceCallOrderItemIsReturnedWithHttp200() {
        Long id = 1L;
        ResponseEntity<ApiResponse<String>> apiResponse = orderItemService.getOrderItem(id);
        assertThat(apiResponse, notNullValue());
        assertThat(apiResponse.getStatusCode().value(), Matchers.is(HttpStatus.OK.value()));
        assertThat(apiResponse.getBody().getMessage(), Matchers.equalTo("Order item :1"));
    }
}
