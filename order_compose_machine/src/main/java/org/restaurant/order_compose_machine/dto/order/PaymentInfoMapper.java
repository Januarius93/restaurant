package org.restaurant.order_compose_machine.dto.order;

import org.restaurant.order_compose_machine.dto.Dto;
import org.restaurant.order_compose_machine.model.order.PaymentInfo;
import org.springframework.stereotype.Component;

@Component
public class PaymentInfoMapper implements Dto<PaymentInfoDto, PaymentInfo> {

  @Override
  public PaymentInfoDto toDto(PaymentInfo paymentInfo) {
    return PaymentInfoDto.builder()
        .price(paymentInfo.getPrice())
        .discount(paymentInfo.getDiscount())
        .taxation(paymentInfo.getTaxation())
        .paymentMethod(paymentInfo.getPaymentMethod())
        .paymentStatus(paymentInfo.getPaymentStatus())
        .build();
  }

  @Override
  public PaymentInfo toEntity(PaymentInfoDto paymentInfoDto) {
    PaymentInfo paymentInfo = new PaymentInfo();
    paymentInfo.setPrice(paymentInfoDto.getPrice());
    paymentInfo.setDiscount(paymentInfoDto.getDiscount());
    paymentInfo.setTaxation(paymentInfoDto.getTaxation());
    paymentInfo.setPaymentMethod(paymentInfoDto.getPaymentMethod());
    paymentInfo.setPaymentStatus(paymentInfoDto.getPaymentStatus());
    return paymentInfo;
  }
}
