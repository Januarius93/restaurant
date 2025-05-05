package org.restaurant.order_compose_machine.repository;

import com.restaurant.dependencies.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
