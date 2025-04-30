package org.restaurant.order_compose_machine.model.order;

import jakarta.persistence.*;
import lombok.*;
import org.restaurant.order_compose_machine.enums.order.OrderItemType;
import org.restaurant.order_compose_machine.enums.order.OrderStatus;

import java.util.List;

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
    private Long orderId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    @Column(name = "order_items")
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
