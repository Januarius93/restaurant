package org.restaurant.order_compose_machine.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@AllArgsConstructor
public class ApiResponse<T> {
    private HttpStatusCode httpStatusCode;
    private String message;
    private T data;
}
