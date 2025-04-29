package org.restaurant.order_compose_machine.service;

import org.restaurant.order_compose_machine.dto.order.OrderDto;
import org.restaurant.order_compose_machine.dto.order.OrderMapper;
import org.restaurant.order_compose_machine.exceptions.OrderExceptions;
import org.restaurant.order_compose_machine.model.order.Order;
import org.restaurant.order_compose_machine.model.order.OrderItem;
import org.restaurant.order_compose_machine.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderDto> getOrders() {
        List<Order> listOfOrders;
        try {
            listOfOrders = orderRepository.findAll();
            log.info("All orders has been successfully get at {}", LocalDateTime.now());
            return listOfOrders.stream().map(order -> orderMapper.toDto(order)).toList();
        } catch (Exception e) {
            log.error("Error during saving order: {}", e.getMessage(), e);
            throw new OrderExceptions.FailedToException("Failed to get orders", e);
        }
    }

    @Override
    public OrderDto getOrder(Long id) {
        Optional<Order> order;
        try {
            order = orderRepository.findById(id);
            log.info("Order {} returned at: {}", id, LocalDateTime.now());
            return orderMapper.toDto(order.get());
        } catch (Exception e) {
            log.error(
                    "Error during getting order: {},: {} at: {} ", id, e.getMessage(), LocalDateTime.now());
            throw new OrderExceptions.FailedToException("Failed to get order", e);
        }
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        try {
            order = orderRepository.save(order);
            log.info(
                    "Order {} has been successfully saved at {}", order.getOrderId(), LocalDateTime.now());
            return orderMapper.toDto(order);
        } catch (Exception e) {
            log.error("Error during saving order: {}, {} at: {} ", e.getMessage(), e.getCause(), LocalDateTime.now());
            throw new OrderExceptions.FailedToException("Failed to create order", e);
        }
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDtoToUpdate, Long orderIdBeingUpdated) {
        Order orderBeingUpdated = orderRepository.findById(orderIdBeingUpdated)
                .orElseThrow(() -> new OrderExceptions.OrderNotFoundException(orderIdBeingUpdated));

        List<OrderItem> orderToUpdateOrderItemList = orderMapper.toEntity(orderDtoToUpdate).getListOfOrderItems();
        orderBeingUpdated.getListOfOrderItems().clear();
        orderBeingUpdated.getListOfOrderItems().addAll(orderToUpdateOrderItemList);
        try {
            Order updatedOrder = orderRepository.save(orderBeingUpdated);
            log.info(
                    "Order {} has been successfully updated at {}",
                    orderBeingUpdated.getOrderId(),
                    LocalDateTime.now());
            return orderMapper.toDto(updatedOrder);
        } catch (Exception e) {
            log.error("Error during updating order: {}, {}", orderBeingUpdated.getOrderId(), e.getMessage(), e);
            throw new OrderExceptions.FailedToException("Failed to update order: ", e);
        }
    }

    @Override
    public OrderDto deleteOrder(Long orderIdToDelete) {
        Order orderBeingDeleted = orderRepository.findById(orderIdToDelete)
                .orElseThrow(() -> new OrderExceptions.OrderNotFoundException(orderIdToDelete));
        try {
            orderRepository.delete(orderBeingDeleted);
            log.info(
                    "Order {} has been successfully deleted at {}",
                    orderBeingDeleted.getOrderId(),
                    LocalDateTime.now());
            return orderMapper.toDto(orderBeingDeleted);
        } catch (Exception e) {
            log.error("Error during deleting order: {},{}", orderBeingDeleted.getOrderId(), e.getMessage(), e);
            throw new OrderExceptions.FailedToException("Failed to delete order: ", e);
        }
    }
}
