package org.restaurant.order_compose_machine.repository;

import org.restaurant.order_compose_machine.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
