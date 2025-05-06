package com.restaurant.menu_svc.service;

import com.restaurant.dependencies.dto.ProductDto;
import java.util.List;

public interface MenuService {
  List<ProductDto> getMenu();
}
