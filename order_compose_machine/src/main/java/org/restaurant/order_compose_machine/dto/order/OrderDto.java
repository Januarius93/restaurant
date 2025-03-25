package org.restaurant.order_compose_machine.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
  @JsonProperty("orderId")
  private Integer id;

  @JsonProperty("orderItems")
  private List<OrderItemDto> listOfOrderItems;

  @JsonProperty("orderDetails")
  private OrderDetailsDto orderDetails;

  @JsonProperty("paymentInfo")
  private PaymentInfoDto paymentInfo;

  @JsonProperty("restaurantSpecificDetails")
  private RestaurantSpecificDetailsDto restaurantSpecificDetails;

  @JsonProperty("orderSpecialNote")
  private String specialNote;
}
