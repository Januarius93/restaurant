package com.restaurant.dependencies.dto.price;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.model.money.price.OrderItemPrice;
import org.springframework.stereotype.Component;

@Component
public class OrderItemPriceMapper implements DtoTransformable<OrderItemPriceDto,OrderItemPrice> {

    @Override
    public OrderItemPriceDto toDto(OrderItemPrice orderItemPrice) {
    return OrderItemPriceDto.builder()
        .priceId(orderItemPrice.getId())
        .totalAmount(orderItemPrice.getTotalAmount())
            .currency(orderItemPrice.getCurrency())
        .build();
    }

    @Override
    public OrderItemPrice toEntity(OrderItemPriceDto orderItemPriceDto) {
    return OrderItemPrice.builder()
            .id(orderItemPriceDto.getPriceId())
            .totalAmount(orderItemPriceDto.getTotalAmount())
            .currency(orderItemPriceDto.getCurrency()).build();
    }
}
