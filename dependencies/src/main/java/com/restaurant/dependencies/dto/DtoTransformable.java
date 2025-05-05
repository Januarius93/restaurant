package com.restaurant.dependencies.dto;

public interface DtoTransformable<dto, entity> {
  dto toDto(entity entity);

  entity toEntity(dto dto);
}
