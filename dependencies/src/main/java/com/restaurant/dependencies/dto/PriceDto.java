package com.restaurant.dependencies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String currency;
}