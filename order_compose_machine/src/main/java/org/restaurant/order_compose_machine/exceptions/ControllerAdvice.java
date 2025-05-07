package org.restaurant.order_compose_machine.exceptions;

import com.restaurant.dependencies.config.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

  private static final Logger log = LoggerFactory.getLogger(ControllerAdvice.class);

  @ExceptionHandler(OrderExceptions.OrderNotFoundException.class)
  public ResponseEntity<ApiResponse<String>> handleOrderNotFoundException(
          OrderExceptions.OrderNotFoundException ex) {
    ApiResponse<String> response =
            new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(OrderItemExceptions.OrderItemNotFoundException.class)
  public ResponseEntity<ApiResponse<String>> handleOrderItemNotFoundException(
          OrderExceptions.OrderNotFoundException ex) {
    ApiResponse<String> response =
            new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(OrderItemExceptions.OrderItemDoubledIdsException.class)
  public ResponseEntity<ApiResponse<String>> handleOrderItemDoubledException(
          OrderExceptions.OrderNotFoundException ex) {
    ApiResponse<String> response =
            new ApiResponse<>(HttpStatus.CONFLICT.value(), ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(OrderExceptions.FailedToException.class)
  public ResponseEntity<ApiResponse<String>> handleFailedToOrderException(
          OrderExceptions.FailedToException ex) {
    ApiResponse<String> response =
            new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(OrderItemExceptions.FailedToException.class)
  public ResponseEntity<ApiResponse<String>> handleFailedToOrderItemException(
          OrderExceptions.FailedToException ex) {
    ApiResponse<String> response =
            new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<String>> handleGenericException(Exception ex) {
    ApiResponse<String> response = new ApiResponse<>(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "An unexpected error occurred",
            null
    );
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

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
