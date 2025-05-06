package com.restaurant.dependencies.dto;

import com.restaurant.dependencies.model.money.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper implements DtoTransformable<PriceDto, Price> {
    @Override
    public PriceDto toDto(Price price) {
        return PriceDto.builder().priceId(price.getPriceId()).totalAmount(price.getTotalAmount()).build();
    }

    @Override
    public Price toEntity(PriceDto priceDto) {
        Price price = new Price();
        price.setPriceId(price.getPriceId());
        price.setTotalAmount(priceDto.getTotalAmount());
        return price;
    }
}
