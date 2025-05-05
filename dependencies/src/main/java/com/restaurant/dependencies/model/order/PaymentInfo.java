package com.restaurant.dependencies.model.order;

import com.restaurant.dependencies.enums.payment.PaymentMethod;
import com.restaurant.dependencies.enums.payment.PaymentStatus;
import com.restaurant.dependencies.model.money.Discount;
import com.restaurant.dependencies.model.money.Price;
import com.restaurant.dependencies.model.money.Tax;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "payment_info")
public class PaymentInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(targetEntity = Price.class, fetch = FetchType.LAZY)
  private Price price;

  @ManyToOne(targetEntity = Discount.class, fetch = FetchType.LAZY)
  private Discount discount;

  @ManyToOne(targetEntity = Tax.class, fetch = FetchType.LAZY)
  private Tax taxation;

  @Enumerated(EnumType.STRING)
  @Column(name = "paymentMethod")
  private PaymentMethod paymentMethod;

  @Enumerated(EnumType.STRING)
  @Column(name = "paymentStatus")
  private PaymentStatus paymentStatus;
}
