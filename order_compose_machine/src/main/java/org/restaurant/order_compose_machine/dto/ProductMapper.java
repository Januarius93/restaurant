package org.restaurant.order_compose_machine.dto;

import org.restaurant.order_compose_machine.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public ProductDto toDto(Product product) {
    return ProductDto.builder()
        .productId(product.getProductId())
        .productName(product.getProductName())
        .productType(product.getProductType())
        .description(product.getDescription())
        .isCustomizable(product.getIsCustomizable())
        .build();
  }

  public Product toEntity(ProductDto productDto) {
    Product product = new Product();
    product.setProductId(productDto.getProductId());
    product.setProductName(productDto.getProductName());
    product.setProductType(productDto.getProductType());
    product.setDescription(productDto.getDescription());
    product.setIsCustomizable(productDto.getIsCustomizable());
    return product;
  }
}
