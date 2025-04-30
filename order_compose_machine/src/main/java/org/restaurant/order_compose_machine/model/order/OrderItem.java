package org.restaurant.order_compose_machine.model.order;

import jakarta.persistence.*;
import lombok.*;
import org.restaurant.order_compose_machine.enums.order.OrderItemType;
import org.restaurant.order_compose_machine.model.money.Price;
import org.restaurant.order_compose_machine.model.product.Product;

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
