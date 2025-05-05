package com.restaurant.menu_svc.service;

import com.restaurant.dependencies.dto.PriceDto;
import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.dependencies.enums.Currency;
import com.restaurant.dependencies.enums.product.ProductType;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
  @Override
  public List<ProductDto> getMenu() {
    return List.of(
        ProductDto.builder()
            .productId(1)
            .productName("Burger")
            .productType(ProductType.MAIN)
            .description("Beef burger")
            .isCustomizable(true)
            .productPrice(
                PriceDto.builder().priceId(1).totalAmount(8.99).currency(Currency.EUR).build())
            .build(),
        ProductDto.builder()
            .productId(2)
            .productName("Pizza")
            .productType(ProductType.MAIN)
            .description("Pepperoni pizza")
            .isCustomizable(true)
            .productPrice(
                PriceDto.builder().priceId(2).totalAmount(12.49).currency(Currency.ZL).build())
            .build(),
        ProductDto.builder()
            .productId(3)
            .productName("Coke")
            .productType(ProductType.BEVERAGES)
            .description("Classic Coke")
            .isCustomizable(false)
            .productPrice(
                PriceDto.builder().priceId(3).totalAmount(1.99).currency(Currency.USD).build())
            .build(),
        ProductDto.builder()
            .productId(4)
            .productName("Water")
            .productType(ProductType.BEVERAGES)
            .description("Mineral water")
            .isCustomizable(false)
            .productPrice(
                PriceDto.builder().priceId(4).totalAmount(1.49).currency(Currency.ZL).build())
            .build(),
        ProductDto.builder()
            .productId(5)
            .productName("Salad")
            .productType(ProductType.SIDES)
            .description("Fresh garden salad")
            .isCustomizable(true)
            .productPrice(
                PriceDto.builder().priceId(5).totalAmount(6.25).currency(Currency.EUR).build())
            .build(),
        ProductDto.builder()
            .productId(6)
            .productName("Coffee")
            .productType(ProductType.BEVERAGES)
            .description("Espresso coffee")
            .isCustomizable(true)
            .productPrice(
                PriceDto.builder().priceId(6).totalAmount(3.15).currency(Currency.USD).build())
            .build());
  }
}
