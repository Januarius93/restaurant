package com.restaurant.dependencies.dto;

import com.restaurant.dependencies.model.money.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper implements DtoTransformable<PriceDto, Price> {
  @Override
  public PriceDto toDto(Price price) {
    return PriceDto.builder()
        .priceId(price.getPriceId())
        .totalAmount(price.getTotalAmount())
        .currency(price.getCurrency())
        .build();
  }

  @Override
  public Price toEntity(PriceDto priceDto) {
    return Price.builder()
        .priceId(priceDto.getPriceId())
        .totalAmount(priceDto.getTotalAmount())
        .currency(priceDto.getCurrency())
        .build();
  }
}
