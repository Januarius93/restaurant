package com.restaurant.dependencies.dto;

import com.restaurant.dependencies.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements DtoTransformable<ProductDto, Product> {

  private final PriceMapper priceMapper;

  public ProductMapper(PriceMapper priceMapper) {
    this.priceMapper = priceMapper;
  }

  public ProductDto toDto(Product product) {
    return ProductDto.builder()
        .productId(product.getProductId())
        .productName(product.getProductName())
        .productType(product.getProductType())
        .description(product.getDescription())
        .isCustomizable(product.getIsCustomizable())
        .productPrice(priceMapper.toDto(product.getProductPrice()))
        .build();
  }

  public Product toEntity(ProductDto productDto) {
    return Product.builder()
        .productName(productDto.getProductName())
        .productType(productDto.getProductType())
        .description(productDto.getDescription())
        .isCustomizable(productDto.getIsCustomizable())
        .productPrice(priceMapper.toEntity(productDto.getProductPrice()))
        .build();
  }
}
