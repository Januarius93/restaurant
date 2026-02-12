package com.restaurant.dependencies.dto.order_item;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.dto.ProductMapper;
import com.restaurant.dependencies.dto.price.OrderItemPriceMapper;
import com.restaurant.dependencies.model.order.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper implements DtoTransformable<OrderItemDto, OrderItem> {

  private final ProductMapper productMapper;
  private final OrderItemPriceMapper orderItemPriceMapper;

  public OrderItemMapper(ProductMapper productMapper, OrderItemPriceMapper orderItemPriceMapper) {

    this.productMapper = productMapper;
    this.orderItemPriceMapper = orderItemPriceMapper;
  }

  public OrderItemDto toDto(OrderItem orderItem) {
    return OrderItemDto.builder()
        .orderItemId(orderItem.getOrderItemId())
        .itemName(orderItem.getItemName())
        .orderItemType(orderItem.getOrderItemType())
        .product(productMapper.toDto(orderItem.getProduct()))
        .quantity(orderItem.getQuantity())
        .price(orderItemPriceMapper.toDto(orderItem.getPrice()))
        .specialNote(orderItem.getSpecialNote())
        .build();
  }

  public OrderItem toEntity(OrderItemDto orderItemDto) {
    OrderItem orderItem = new OrderItem();
    orderItem.setOrderItemId(null);
    orderItem.setItemName(orderItemDto.getItemName());
    orderItem.setOrderItemType(orderItemDto.getOrderItemType());
    orderItem.setProduct(productMapper.toEntity(orderItemDto.getProduct()));
    orderItem.setQuantity(orderItemDto.getQuantity());
    orderItem.setPrice(orderItemPriceMapper.toEntity(orderItemDto.getPrice()));
    orderItem.setSpecialNote(orderItemDto.getSpecialNote());
    return orderItem;
  }
}
