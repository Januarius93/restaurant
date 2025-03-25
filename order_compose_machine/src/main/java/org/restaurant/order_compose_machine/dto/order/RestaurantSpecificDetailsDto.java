package org.restaurant.order_compose_machine.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restaurant.order_compose_machine.model.Restaurant;
import org.restaurant.order_compose_machine.model.person.Person;

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
