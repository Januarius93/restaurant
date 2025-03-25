package org.restaurant.order_compose_machine.repository;

import org.restaurant.order_compose_machine.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
