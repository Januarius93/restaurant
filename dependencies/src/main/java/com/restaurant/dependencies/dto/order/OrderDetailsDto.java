package com.restaurant.dependencies.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.dependencies.enums.order.OrderStatus;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {

  @JsonProperty("customerData")
  private CustomerDataDto customerData;

  @JsonProperty("orderId")
  private Integer orderId;

  @JsonProperty("orderDate")
  private LocalDate orderDate;

  @JsonProperty("orderStatus")
  private OrderStatus orderStatus;
}
