package org.restaurant.order_compose_machine.model.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.restaurant.order_compose_machine.enums.order.OrderStatus;
import org.restaurant.order_compose_machine.model.CustomerData;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(targetEntity = CustomerData.class, fetch = FetchType.LAZY)
    private CustomerData customerData;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;
}
