package com.restaurant.dependencies.model.money;

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
  private String currency;
}
