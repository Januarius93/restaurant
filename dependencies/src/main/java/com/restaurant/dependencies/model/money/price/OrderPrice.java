package com.restaurant.dependencies.model.money.price;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "order_price")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderPrice extends Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
