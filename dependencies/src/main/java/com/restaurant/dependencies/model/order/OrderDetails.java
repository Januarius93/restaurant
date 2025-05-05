package com.restaurant.dependencies.model.order;

import com.restaurant.dependencies.enums.order.OrderStatus;
import com.restaurant.dependencies.model.CustomerData;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_details")
public class OrderDetails {
  @Id
  @Column(name = "order_id")
  private Integer orderId;

  @ManyToOne(targetEntity = CustomerData.class, fetch = FetchType.LAZY)
  private CustomerData customerData;

  @Column(name = "order_date")
  private LocalDate orderDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "order_status")
  private OrderStatus orderStatus;
}
