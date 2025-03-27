package org.restaurant.order_compose_machine.model.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.restaurant.order_compose_machine.enums.product.ProductType;

@Entity
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Integer productId;

  @Column(name = "product_name")
  private String productName;

  @Enumerated(EnumType.STRING)
  @Column(name = "product_type")
  private ProductType productType;

  @Column(name = "product_description")
  private String description;

  @Column(name = "is_customizable")
  private Boolean isCustomizable;
}
