package com.restaurant.dependencies.model.order;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long orderId = null;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "order_id")
  private List<OrderItem> listOfOrderItems;

  //
  //  @ManyToOne(targetEntity = OrderDetails.class, fetch = FetchType.LAZY)
  //  private OrderDetails orderDetails;
  //
  //  @ManyToOne(targetEntity = PaymentInfo.class, fetch = FetchType.LAZY)
  //  private PaymentInfo paymentInfo;
  //
  //  @Column(name = "order_special_note")
  //  private String specialNote;
  //
  //  @ManyToOne(targetEntity = RestaurantSpecificDetails.class, fetch = FetchType.LAZY)
  //  private RestaurantSpecificDetails restaurantSpecificDetails;
}
