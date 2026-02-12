package com.restaurant.menu_svc.service;

import com.restaurant.dependencies.dto.MenuDto;
import com.restaurant.dependencies.dto.price.PriceDto;
import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.dependencies.dto.price.ProductPriceDto;
import com.restaurant.dependencies.enums.Currency;
import com.restaurant.dependencies.enums.product.ProductType;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
  @Override
  public MenuDto getMenu() {
    return MenuDto.builder()
        .menuId(1L)
        .productDtoList(
            List.of(
                ProductDto.builder()
                    .productId(1)
                    .productName("Burger")
                    .productType(ProductType.MAIN)
                    .description("Beef burger")
                    .isCustomizable(true)
                    .productPriceDto(
                        ProductPriceDto.builder()
                            .priceId(1L)
                            .totalAmount(8.99)
                            .currency(Currency.EUR)
                            .build())
                    .build(),
                ProductDto.builder()
                    .productId(2)
                    .productName("Pizza")
                    .productType(ProductType.MAIN)
                    .description("Pepperoni pizza")
                    .isCustomizable(true)
                    .productPriceDto(
                        ProductPriceDto.builder()
                            .priceId(2L)
                            .totalAmount(12.49)
                            .currency(Currency.ZL)
                            .build())
                    .build(),
                ProductDto.builder()
                    .productId(3)
                    .productName("Coke")
                    .productType(ProductType.BEVERAGES)
                    .description("Classic Coke")
                    .isCustomizable(false)
                    .productPriceDto(
                        ProductPriceDto.builder()
                            .priceId(3L)
                            .totalAmount(1.99)
                            .currency(Currency.USD)
                            .build())
                    .build(),
                ProductDto.builder()
                    .productId(4)
                    .productName("Water")
                    .productType(ProductType.BEVERAGES)
                    .description("Mineral water")
                    .isCustomizable(false)
                    .productPriceDto(
                        ProductPriceDto.builder()
                            .priceId(4L)
                            .totalAmount(1.49)
                            .currency(Currency.ZL)
                            .build())
                    .build(),
                ProductDto.builder()
                    .productId(5)
                    .productName("Salad")
                    .productType(ProductType.SIDES)
                    .description("Fresh garden salad")
                    .isCustomizable(true)
                    .productPriceDto(
                        ProductPriceDto.builder()
                            .priceId(5L)
                            .totalAmount(6.25)
                            .currency(Currency.EUR)
                            .build())
                    .build(),
                ProductDto.builder()
                    .productId(6)
                    .productName("Coffee")
                    .productType(ProductType.BEVERAGES)
                    .description("Espresso coffee")
                    .isCustomizable(true)
                    .productPriceDto(
                        ProductPriceDto.builder()
                            .priceId(6L)
                            .totalAmount(3.15)
                            .currency(Currency.USD)
                            .build())
                    .build()))
        .build();
  }
}
