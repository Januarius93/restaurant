package com.restaurant.dependencies.dto.order;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.dto.order_item.OrderItemMapper;
import com.restaurant.dependencies.model.order.Order;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements DtoTransformable<OrderDto, Order> {

  private final OrderItemMapper orderItemMapper;
  private final OrderDetailsMapper orderDetailsMapper;
  private final PaymentInfoMapper paymentInfoMapper;
  private final RestaurantSpecificDetailsMapper restaurantSpecificDetailsMapper;

  public OrderMapper(
      OrderItemMapper orderItemMapper,
      OrderDetailsMapper orderDetailsMapper,
      PaymentInfoMapper paymentInfoMapper,
      RestaurantSpecificDetailsMapper restaurantSpecificDetailsMapper) {
    this.orderItemMapper = orderItemMapper;
    this.orderDetailsMapper = orderDetailsMapper;
    this.paymentInfoMapper = paymentInfoMapper;
    this.restaurantSpecificDetailsMapper = restaurantSpecificDetailsMapper;
  }

  @Override
  public OrderDto toDto(Order order) {
    return OrderDto.builder()
        .orderId(order.getOrderId())
        .listOfOrderItems(
            order.getListOfOrderItems().stream()
                .map(orderItemMapper::toDto)
                .collect(Collectors.toList()))

        /** No need for now* */
        //        .orderDetails(orderDetailsMapper.toDto(order.getOrderDetails()))
        //        .paymentInfo(paymentInfoMapper.toDto(order.getPaymentInfo()))
        //        .restaurantSpecificDetails(
        //            restaurantSpecificDetailsMapper.toDto(order.getRestaurantSpecificDetails()))
        //        .specialNote(order.getSpecialNote())
        .build();
  }

  @Override
  public Order toEntity(OrderDto orderDto) {
    Order order = new Order();
    order.setListOfOrderItems(
        orderDto.getListOfOrderItems().stream()
            .map(orderItemMapper::toEntity)
            .collect(Collectors.toList()));
    /** No need for now* */
    //    order.setOrderDetails(orderDetailsMapper.toEntity(orderDto.getOrderDetails()));
    //    order.setPaymentInfo(paymentInfoMapper.toEntity(orderDto.getPaymentInfo()));
    //    order.setRestaurantSpecificDetails(
    //        restaurantSpecificDetailsMapper.toEntity(orderDto.getRestaurantSpecificDetails()));
    //    order.setSpecialNote(orderDto.getSpecialNote());
    return order;
  }
}
