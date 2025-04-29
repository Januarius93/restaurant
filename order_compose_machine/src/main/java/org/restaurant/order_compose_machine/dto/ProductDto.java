package org.restaurant.order_compose_machine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restaurant.order_compose_machine.enums.product.ProductType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @JsonProperty("productId")
    private Integer productId;

    @JsonProperty("productName")
    private String productName;

    @Enumerated(EnumType.STRING)
    @JsonProperty("productType")
    private ProductType productType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("isCustomizable")
    private Boolean isCustomizable;
}
