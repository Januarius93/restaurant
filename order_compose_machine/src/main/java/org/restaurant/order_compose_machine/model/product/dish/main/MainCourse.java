package org.restaurant.order_compose_machine.model.product.dish.main;

import org.restaurant.order_compose_machine.enums.product.MainCourseType;
import org.restaurant.order_compose_machine.enums.product.Size;
import org.restaurant.order_compose_machine.model.product.Product;

abstract class MainCourse extends Product {
  private Size size;
  private MainCourseType mainCourseType;
}
