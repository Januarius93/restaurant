package org.restaurant.order_compose_machine.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restaurant.order_compose_machine.enums.order.OrderStatus;

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
