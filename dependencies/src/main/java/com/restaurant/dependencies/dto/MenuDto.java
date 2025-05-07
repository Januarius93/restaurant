package com.restaurant.dependencies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto implements Serializable {
  @JsonProperty("menuId")
  private Long menuId;

  @JsonProperty("productsList")
  private List<ProductDto> productDtoList;
}
