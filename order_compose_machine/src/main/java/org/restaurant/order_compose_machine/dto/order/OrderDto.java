package org.restaurant.order_compose_machine.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.restaurant.order_compose_machine.dto.Dto;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.restaurant.order_compose_machine.enums.order.OrderStatus;

import java.util.List;

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
