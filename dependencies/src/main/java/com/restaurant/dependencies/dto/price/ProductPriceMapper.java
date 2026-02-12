package com.restaurant.dependencies.dto.price;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.model.money.price.OrderItemPrice;
import com.restaurant.dependencies.model.money.price.OrderPrice;
import com.restaurant.dependencies.model.money.price.ProductPrice;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceMapper implements DtoTransformable<ProductPriceDto, ProductPrice> {

    @Override
    public ProductPriceDto toDto(ProductPrice productPrice) {
        return ProductPriceDto.builder()
                .priceId(productPrice.getId())
                .totalAmount(productPrice.getTotalAmount())
                .currency(productPrice.getCurrency())
                .build();
    }

    @Override
    public ProductPrice toEntity(ProductPriceDto productPriceDto) {
        return ProductPrice.builder()
                .id(productPriceDto.getPriceId())
                .totalAmount(productPriceDto.getTotalAmount())
                .currency(productPriceDto.getCurrency()).build();
    }
}
