package com.restaurant.dependencies.dto.order;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.model.order.RestaurantSpecificDetails;
import org.springframework.stereotype.Component;

@Component
public class RestaurantSpecificDetailsMapper
    implements DtoTransformable<RestaurantSpecificDetailsDto, RestaurantSpecificDetails> {

  public RestaurantSpecificDetailsDto toDto(RestaurantSpecificDetails details) {
    return RestaurantSpecificDetailsDto.builder()
        .tableNumber(details.getTableNumber())
        .staffMember(details.getStaffMember())
        .restaurant(details.getRestaurant())
        .build();
  }

  public RestaurantSpecificDetails toEntity(RestaurantSpecificDetailsDto dto) {
    RestaurantSpecificDetails details = new RestaurantSpecificDetails();
    details.setTableNumber(dto.getTableNumber());
    details.setStaffMember(dto.getStaffMember());
    details.setRestaurant(dto.getRestaurant());
    return details;
  }
}
