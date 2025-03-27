package org.restaurant.order_compose_machine.model;

import jakarta.persistence.*;

@Entity
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
}
