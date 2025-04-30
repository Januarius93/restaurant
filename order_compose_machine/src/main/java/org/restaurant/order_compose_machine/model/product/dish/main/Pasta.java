package org.restaurant.order_compose_machine.model.product.dish.main;

import lombok.Data;
import org.restaurant.order_compose_machine.enums.product.PastaSauceType;
import org.restaurant.order_compose_machine.enums.product.PastaType;

@Data
public class Pasta extends MainCourse {
  private PastaType pastaType;
  private PastaSauceType pastaSauceType;
}
