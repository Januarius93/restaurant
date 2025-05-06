package com.restaurant.dependencies.dto.order_item;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.dto.PriceMapper;
import com.restaurant.dependencies.dto.ProductMapper;
import com.restaurant.dependencies.model.order.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper implements DtoTransformable<OrderItemDto, OrderItem> {

  private final ProductMapper productMapper;
  private final PriceMapper priceMapper;

  public OrderItemMapper(ProductMapper productMapper, PriceMapper priceMapper) {

    this.productMapper = productMapper;
    this.priceMapper = priceMapper;
  }

  public OrderItemDto toDto(OrderItem orderItem) {
    return OrderItemDto.builder()
        .orderItemId(orderItem.getOrderItemId())
        .itemName(orderItem.getItemName())
        .orderItemType(orderItem.getOrderItemType())
        .product(productMapper.toDto(orderItem.getProduct()))
        .quantity(orderItem.getQuantity())
        .price(priceMapper.toDto(orderItem.getPrice()))
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
    orderItem.setPrice(priceMapper.toEntity(orderItemDto.getPrice()));
    orderItem.setSpecialNote(orderItemDto.getSpecialNote());
    return orderItem;
  }
}
