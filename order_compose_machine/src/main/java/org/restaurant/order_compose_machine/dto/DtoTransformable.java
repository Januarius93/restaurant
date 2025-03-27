package org.restaurant.order_compose_machine.dto;

public interface DtoTransformable<dto, entity> {
   dto toDto(entity entity);

   entity toEntity(dto dto);
}
