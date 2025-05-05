package com.restaurant.dependencies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "address_id")
  private Integer addressId;

  @Column(name = "city")
  private String city;

  @Column(name = "street_name")
  private String streetName;

  @Column(name = "street_number")
  private Integer streetNumber;

  @Column(name = "home_number")
  private Integer homeNumber;

  @Column(name = "postalCode")
  private String postalCode;
}
