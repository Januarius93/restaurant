package com.restaurant.dependencies.dto;

import com.restaurant.dependencies.model.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper implements DtoTransformable<MenuDto, Menu> {

  private ProductMapper productMapper;

  @Override
  public MenuDto toDto(Menu menu) {
    return MenuDto.builder()
        .menuId(menu.getMenuId())
        .productDtoList(
            menu.getProductsList().stream().map(product -> productMapper.toDto(product)).toList())
        .build();
  }

  @Override
  public Menu toEntity(MenuDto menuDto) {
    return Menu.builder()
        .menuId(menuDto.getMenuId())
        .productsList(
            menuDto.getProductDtoList().stream()
                .map(productDto -> productMapper.toEntity(productDto))
                .toList())
        .build();
  }
}
