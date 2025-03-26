package org.restaurant.order_compose_machine.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.restaurant.order_compose_machine.dto.order_item.OrderItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@AllArgsConstructor
public class ApiResponse<T> {
    private Integer httpStatusCode;
    private String message;
    private T data;
}
