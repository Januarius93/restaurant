package com.restaurant.dependencies.model;

import com.restaurant.dependencies.model.person.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
