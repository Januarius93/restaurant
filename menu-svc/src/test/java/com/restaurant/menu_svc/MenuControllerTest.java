package com.restaurant.menu_svc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

import com.restaurant.dependencies.config.ApiResponse;
import com.restaurant.dependencies.dto.MenuDto;
import com.restaurant.dependencies.dto.price.PriceDto;
import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.dependencies.enums.Currency;
import com.restaurant.dependencies.enums.product.ProductType;
import com.restaurant.menu_svc.controller.MenuController;
import com.restaurant.menu_svc.service.MenuServiceImpl;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class MenuControllerTest {
  @Mock private MenuServiceImpl menuService;
  @InjectMocks private MenuController menuController;

  @Test
  public void withGetMenuCallAllAllProductsAreReturnedWithHttp200() {
    MenuDto menu =
        MenuDto.builder()
            .menuId(1L)
            .productDtoList(
                List.of(
                    ProductDto.builder()
                        .productId(1)
                        .productName("Burger")
                        .productType(ProductType.MAIN)
                        .description("Beef burger")
                        .isCustomizable(true)
                        .priceDto(
                            PriceDto.builder()
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
                        .priceDto(
                            PriceDto.builder()
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
                        .priceDto(
                            PriceDto.builder()
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
                        .priceDto(
                            PriceDto.builder()
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
                        .priceDto(
                            PriceDto.builder()
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
                        .priceDto(
                            PriceDto.builder()
                                .priceId(6L)
                                .totalAmount(3.15)
                                .currency(Currency.USD)
                                .build())
                        .build()))
            .build();
    when(menuService.getMenu()).thenReturn(menu);
    ResponseEntity<ApiResponse<MenuDto>> apiResponseResponseEntity =
        menuController.getMenu();

    assertThat(apiResponseResponseEntity, notNullValue());
    assertThat(apiResponseResponseEntity.getBody().getData().getProductDtoList().size(), Matchers.is(6));
    assertThat(
        apiResponseResponseEntity.getBody().getData().getProductDtoList().get(0).getDescription(),
        Matchers.is("Beef burger"));
  }
}
