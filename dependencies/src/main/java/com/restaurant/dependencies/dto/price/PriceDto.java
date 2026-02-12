package com.restaurant.dependencies.dto.price;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.dependencies.dto.Dto;
import com.restaurant.dependencies.enums.Currency;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
    @JsonProperty("priceId")
    private Long priceId;

    @JsonProperty("totalAmount")
    private Double totalAmount;

    @JsonProperty("currency")
    private Currency currency;
}
