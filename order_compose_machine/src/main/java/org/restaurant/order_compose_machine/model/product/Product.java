package org.restaurant.order_compose_machine.model.product;

import jakarta.persistence.*;
import lombok.*;
import org.restaurant.order_compose_machine.enums.product.ProductType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
