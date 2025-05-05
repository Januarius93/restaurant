package com.restaurant.dependencies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.dependencies.enums.Currency;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto extends Dto {
  @JsonProperty("priceId")
  private Integer priceId;

  @JsonProperty("totalAmount")
  private Double totalAmount;

  @JsonProperty("currency")
  private Currency currency;
}
