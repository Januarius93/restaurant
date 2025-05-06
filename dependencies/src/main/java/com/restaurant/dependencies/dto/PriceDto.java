package com.restaurant.dependencies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.dependencies.enums.Currency;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
public class PriceDto extends Dto {
    @JsonProperty("priceId")
    private Long priceId;

    @JsonProperty("totalAmount")
    private Double totalAmount;

    @JsonProperty("currency")
    private Currency currency;
}