package org.restaurant.order_compose_machine.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApiResponse<T> {
  private Integer httpStatusCode;
  private String message;
  private T data;
}
