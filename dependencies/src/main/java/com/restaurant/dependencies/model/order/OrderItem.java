package com.restaurant.dependencies.model.order;

import com.restaurant.dependencies.enums.order.OrderItemType;
import com.restaurant.dependencies.model.money.Price;
import com.restaurant.dependencies.model.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_item_id")
  private Long orderItemId;

  @Column(name = "order_item_name")
  private String itemName;

  @Enumerated(EnumType.STRING)
  @Column(name = "order_item_type")
  private OrderItemType orderItemType;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(name = "quantity")
  private Integer quantity;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "price_id")
  private Price price;

  @Column(name = "special_note")
  private String specialNote;
}
