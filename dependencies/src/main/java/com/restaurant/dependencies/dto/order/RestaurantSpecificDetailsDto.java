package com.restaurant.dependencies.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.dependencies.model.Restaurant;
import com.restaurant.dependencies.model.person.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantSpecificDetailsDto {
  @JsonProperty("tableNumber")
  private Integer tableNumber;

  @JsonProperty("staffMember")
  private Person staffMember;

  @JsonProperty("restaurant")
  private Restaurant restaurant;
}
