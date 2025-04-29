package org.restaurant.order_compose_machine.dto.order;

import org.restaurant.order_compose_machine.dto.DtoTransformable;
import org.restaurant.order_compose_machine.model.order.RestaurantSpecificDetails;
import org.springframework.stereotype.Component;

@Component
public class RestaurantSpecificDetailsMapper implements DtoTransformable<RestaurantSpecificDetailsDto, RestaurantSpecificDetails> {

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
