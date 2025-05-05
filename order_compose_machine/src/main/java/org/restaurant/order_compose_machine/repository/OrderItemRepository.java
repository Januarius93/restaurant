package org.restaurant.order_compose_machine.repository;

import com.restaurant.dependencies.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
