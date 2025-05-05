package com.restaurant.dependencies.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.dependencies.dto.Dto;
import com.restaurant.dependencies.dto.order_item.OrderItemDto;
import java.util.List;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto extends Dto {
  @JsonProperty("orderId")
  private Long orderId;

  @JsonProperty("orderItems")
  private List<OrderItemDto> listOfOrderItems;

  //  @JsonProperty("orderDetails")
  //  private OrderDetailsDto orderDetails;
  //
  //  @JsonProperty("paymentInfo")
  //  private PaymentInfoDto paymentInfo;
  //
  //  @JsonProperty("restaurantSpecificDetails")
  //  private RestaurantSpecificDetailsDto restaurantSpecificDetails;
  //
  //  @JsonProperty("orderSpecialNote")
  //  private String specialNote;
}
