package com.restaurant.dependencies.dto.price;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.model.money.price.OrderItemPrice;
import com.restaurant.dependencies.model.money.price.OrderPrice;

public class OrderPriceMapper implements DtoTransformable<OrderPriceDto, OrderPrice> {
    @Override
    public OrderPriceDto toDto(OrderPrice orderPrice) {
        return OrderPriceDto.builder()
                .priceId(orderPrice.getId())
                .totalAmount(orderPrice.getTotalAmount())
                .currency(orderPrice.getCurrency())
                .build();
    }

    @Override
    public OrderPrice toEntity(OrderPriceDto orderPriceDto) {
        return OrderPrice.builder()
                .id(orderPriceDto.getPriceId())
                .totalAmount(orderPriceDto.getTotalAmount())
                .currency(orderPriceDto.getCurrency()).build();
    }
}
