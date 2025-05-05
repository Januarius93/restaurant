package com.restaurant.dependencies.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.dependencies.enums.payment.PaymentMethod;
import com.restaurant.dependencies.enums.payment.PaymentStatus;
import com.restaurant.dependencies.model.money.Discount;
import com.restaurant.dependencies.model.money.Price;
import com.restaurant.dependencies.model.money.Tax;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfoDto {

  @JsonProperty("price")
  private Price price;

  @JsonProperty("discount")
  private Discount discount;

  @JsonProperty("taxation")
  private Tax taxation;

  @JsonProperty("paymentMethod")
  private PaymentMethod paymentMethod;

  @JsonProperty("paymentStatus")
  private PaymentStatus paymentStatus;
}
