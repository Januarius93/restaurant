package com.restaurant.dependencies.model.money;

import com.restaurant.dependencies.enums.Currency;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Integer priceId;

  @Column(name = "total_amount")
  private Double totalAmount;

  @Column(name = "currency")
  private Currency currency;
}
