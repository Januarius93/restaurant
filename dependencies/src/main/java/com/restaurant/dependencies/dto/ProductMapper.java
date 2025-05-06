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
        .priceDto(priceMapper.toDto(product.getPrice()))
        .build();
  }

  public Product toEntity(ProductDto productDto) {
    Product product = new Product();
    product.setProductName(productDto.getProductName());
    product.setProductType(productDto.getProductType());
    product.setDescription(productDto.getDescription());
    product.setIsCustomizable(productDto.getIsCustomizable());
    product.setPrice(priceMapper.toEntity(productDto.getPriceDto()));
    return product;
  }
}
