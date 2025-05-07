package com.restaurant.dependencies.model;

import com.restaurant.dependencies.model.product.Product;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "menu_id")
  private Long menuId;

  @Column(name = "productsList")
  @OneToMany
  private List<Product> productsList;
}
