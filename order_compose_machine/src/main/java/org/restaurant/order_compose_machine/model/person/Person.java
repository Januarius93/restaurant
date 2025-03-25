package org.restaurant.order_compose_machine.model.person;

import jakarta.persistence.*;
import org.restaurant.order_compose_machine.enums.PersonType;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  private PersonType personType;
  private StringBuffer name;
  private StringBuffer surname;
}
