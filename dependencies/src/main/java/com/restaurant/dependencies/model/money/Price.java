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
  @Column(name = "price_id")
  private Long priceId;

  @Column(name = "total_amount")
  private Double totalAmount;

  @Column(name = "currency")
  @Enumerated(EnumType.STRING)
  private Currency currency;
}
