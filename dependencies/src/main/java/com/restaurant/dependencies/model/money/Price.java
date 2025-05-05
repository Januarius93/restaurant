package com.restaurant.dependencies.model.money;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Price {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "total_amount")
  private Double totalAmount;

  public Price() {}
}
