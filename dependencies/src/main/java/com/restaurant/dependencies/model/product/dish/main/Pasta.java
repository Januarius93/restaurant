package com.restaurant.dependencies.model.product.dish.main;

import com.restaurant.dependencies.enums.product.PastaSauceType;
import com.restaurant.dependencies.enums.product.PastaType;
import lombok.Data;

@Data
public class Pasta extends MainCourse {
  private PastaType pastaType;
  private PastaSauceType pastaSauceType;
}
