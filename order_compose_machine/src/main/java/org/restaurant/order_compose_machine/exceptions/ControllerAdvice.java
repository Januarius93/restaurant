package org.restaurant.order_compose_machine.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.restaurant.order_compose_machine.config.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ApiResponse<Map<String, String>>> handleConstraintViolationException(
      ConstraintViolationException exception) {
    Map<String, String> errorMap = getConstrainsViolations(exception);

    ApiResponse<Map<String, String>> apiResponse =
        ApiResponse.<Map<String, String>>builder()
            .httpStatusCode(HttpStatus.BAD_REQUEST.value())
            .message("Validation failed")
            .data(errorMap)
            .build();

    return ResponseEntity.badRequest().body(apiResponse);
  }

  private Map<String, String> getConstrainsViolations(ConstraintViolationException exception) {
    return exception.getConstraintViolations().stream()
        .collect(
            Collectors.toMap(
                constraintViolation -> constraintViolation.getPropertyPath().toString(),
                ConstraintViolation::getMessage));
  }
}
