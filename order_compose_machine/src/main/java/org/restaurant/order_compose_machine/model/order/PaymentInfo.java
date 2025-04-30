package org.restaurant.order_compose_machine.model.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.restaurant.order_compose_machine.enums.payment.PaymentMethod;
import org.restaurant.order_compose_machine.enums.payment.PaymentStatus;
import org.restaurant.order_compose_machine.model.money.Discount;
import org.restaurant.order_compose_machine.model.money.Price;
import org.restaurant.order_compose_machine.model.money.Tax;

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
