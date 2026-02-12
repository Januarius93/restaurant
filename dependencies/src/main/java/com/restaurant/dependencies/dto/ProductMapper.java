package com.restaurant.dependencies.dto;


import com.restaurant.dependencies.dto.price.ProductPriceMapper;
import com.restaurant.dependencies.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements DtoTransformable<ProductDto, Product> {

  private final ProductPriceMapper productPriceMapper;

  public ProductMapper(ProductPriceMapper productPriceMapper) {
    this.productPriceMapper = productPriceMapper;
  }

  public ProductDto toDto(Product product) {
    return ProductDto.builder()
        .productId(product.getProductId())
        .productName(product.getProductName())
        .productType(product.getProductType())
        .description(product.getDescription())
        .isCustomizable(product.getIsCustomizable())
        .productPriceDto(productPriceMapper.toDto(product.getPrice()))
        .build();
  }

  public Product toEntity(ProductDto productDto) {
    Product product = new Product();
    product.setProductName(productDto.getProductName());
    product.setProductType(productDto.getProductType());
    product.setDescription(productDto.getDescription());
    product.setIsCustomizable(productDto.getIsCustomizable());
    product.setPrice(productPriceMapper.toEntity(productDto.getProductPriceDto()));
    return product;
  }
}
