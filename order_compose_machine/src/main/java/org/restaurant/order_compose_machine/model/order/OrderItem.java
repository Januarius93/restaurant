package org.restaurant.order_compose_machine.model.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.restaurant.order_compose_machine.enums.order.OrderItemType;
import org.restaurant.order_compose_machine.model.product.Product;
import org.restaurant.order_compose_machine.model.money.Price;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "order_item_name")
  private String itemName;

  @Enumerated(EnumType.STRING)
  @Column(name = "order_item_type")
  private OrderItemType orderItemType;

  @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
  private Product product;

  @Column(name = "quantity")
  private Integer quantity;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "price_id")
  private Price price;

  @Column(name = "special_note")
  private String specialNote;
}
