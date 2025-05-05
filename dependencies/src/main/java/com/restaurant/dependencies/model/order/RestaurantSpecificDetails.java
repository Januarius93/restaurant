package com.restaurant.dependencies.model.order;

import com.restaurant.dependencies.model.Restaurant;
import com.restaurant.dependencies.model.person.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "restaurant_specific_details")
public class RestaurantSpecificDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "table_number")
  private Integer tableNumber;

  @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
  private Person staffMember;

  @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
  private Restaurant restaurant;
}
