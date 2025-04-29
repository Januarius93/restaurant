package org.restaurant.order_compose_machine.model.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.restaurant.order_compose_machine.model.Restaurant;
import org.restaurant.order_compose_machine.model.person.Person;

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
