package org.restaurant.order_compose_machine.unit.controller.order;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
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

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DeleteOrderControllerUnitTest extends AbstractUnitTest implements OCMUnitTest {

    @Mock
    private OrderServiceImpl orderService;
    @InjectMocks
    private OrderController orderController;

    @SneakyThrows
    @Test
    public void withProperOrderPayloadOrderDeletedWithHttp200() {
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

        when(orderService.deleteOrder(orderId)).thenReturn(existingOrderDto);
        ResponseEntity<ApiResponse<OrderDto>> apiResponseResponseEntity = orderController.deleteOrder(1L);
        assertThat(apiResponseResponseEntity.getStatusCode(), is(HttpStatus.OK));
        Assertions.assertNotNull(apiResponseResponseEntity.getBody());
        assertThat(apiResponseResponseEntity.getBody().getMessage(), is("Order: 1 deleted"));
        verify(orderService).deleteOrder(1L);
    }
}
