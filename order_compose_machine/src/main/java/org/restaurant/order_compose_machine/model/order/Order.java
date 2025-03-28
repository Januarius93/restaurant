package org.restaurant.order_compose_machine.model.order;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_table")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Integer orderId;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "order_id")
  private List<OrderItem> listOfOrderItems;

  @ManyToOne(targetEntity = OrderDetails.class, fetch = FetchType.LAZY)
  private OrderDetails orderDetails;

  @ManyToOne(targetEntity = PaymentInfo.class, fetch = FetchType.LAZY)
  private PaymentInfo paymentInfo;

  @Column(name = "order_special_note")
  private String specialNote;

  @ManyToOne(targetEntity = RestaurantSpecificDetails.class, fetch = FetchType.LAZY)
  private RestaurantSpecificDetails restaurantSpecificDetails;
}
