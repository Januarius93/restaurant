package com.restaurant.dependencies.dto.order;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.model.order.OrderDetails;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsMapper implements DtoTransformable<OrderDetailsDto, OrderDetails> {
  private final CustomerDataMapper customerDataMapper;

  public OrderDetailsMapper(CustomerDataMapper customerDataMapper) {
    this.customerDataMapper = customerDataMapper;
  }

  @Override
  public OrderDetailsDto toDto(OrderDetails orderDetails) {
    return OrderDetailsDto.builder()
        .orderId(orderDetails.getOrderId())
        .customerData(customerDataMapper.toDto(orderDetails.getCustomerData()))
        .orderDate(orderDetails.getOrderDate())
        .orderStatus(orderDetails.getOrderStatus())
        .build();
  }

  @Override
  public OrderDetails toEntity(OrderDetailsDto orderDetailsDto) {
    OrderDetails orderDetails = new OrderDetails();
    orderDetails.setOrderId(orderDetailsDto.getOrderId());
    orderDetails.setCustomerData(customerDataMapper.toEntity(orderDetailsDto.getCustomerData()));
    orderDetails.setOrderDate(orderDetailsDto.getOrderDate());
    orderDetails.setOrderStatus(orderDetailsDto.getOrderStatus());
    return orderDetails;
  }
}
