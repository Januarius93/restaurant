package com.restaurant.dependencies.model.person;

import com.restaurant.dependencies.enums.PersonType;
import jakarta.persistence.*;

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
