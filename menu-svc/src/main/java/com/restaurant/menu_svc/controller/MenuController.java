package com.restaurant.menu_svc.controller;

import com.restaurant.dependencies.config.ApiResponse;
import com.restaurant.dependencies.dto.ProductDto;
import com.restaurant.menu_svc.service.MenuServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("api/menu")
public class MenuController {
  @Autowired private MenuServiceImpl menuService;

  @GetMapping("/getMenu")
  public ResponseEntity<ApiResponse<List<ProductDto>>> getMenu() {
    List<ProductDto> menu = menuService.getMenu();
    return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "All available products returned", menu));
  }
}
