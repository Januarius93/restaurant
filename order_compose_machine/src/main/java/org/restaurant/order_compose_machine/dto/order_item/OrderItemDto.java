package org.restaurant.order_compose_machine.dto.order_item;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restaurant.order_compose_machine.dto.ProductDto;
import org.restaurant.order_compose_machine.enums.order.OrderItemType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

  @JsonProperty("itemName")
  @NotBlank(message = "Item name can not be blank")
  private String itemName;

  @Enumerated(EnumType.STRING)
  @JsonProperty("orderItemType")
  private OrderItemType orderItemType;

  @JsonProperty("product")
  private ProductDto product;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("specialNoteOrderItem")
  private String specialNote;
}
