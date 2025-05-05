package com.restaurant.dependencies.model.product.dish.main;

import com.restaurant.dependencies.enums.product.MainCourseType;
import com.restaurant.dependencies.enums.product.Size;
import com.restaurant.dependencies.model.product.Product;

abstract class MainCourse extends Product {
  private Size size;
  private MainCourseType mainCourseType;
}
