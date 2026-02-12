package com.restaurant.dependencies.model.money.price;

import com.restaurant.dependencies.enums.Currency;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Price {
  @Column(name = "total_amount")
  private Double totalAmount;

  @Column(name = "currency")
  @Enumerated(EnumType.STRING)
  private Currency currency;
}
