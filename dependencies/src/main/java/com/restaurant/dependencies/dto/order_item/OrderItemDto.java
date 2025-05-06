package com.restaurant.dependencies.dto.order_item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.dependencies.dto.Dto;
import com.restaurant.dependencies.dto.PriceDto;
import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.dependencies.enums.order.OrderItemType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto extends Dto {

  @JsonProperty("orderItemId")
  private Long orderItemId;

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
  private PriceDto price;

  @JsonProperty("specialNoteOrderItem")
  private String specialNote;
}
