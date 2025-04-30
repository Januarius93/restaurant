package org.restaurant.order_compose_machine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.restaurant.order_compose_machine.model.person.Customer;

@Entity
@Getter
@Setter
@Table(name = "customer_data")
public class CustomerData {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer customerDataId;

  @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
  private Customer customer;

  @ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY)
  private Address address;
}
