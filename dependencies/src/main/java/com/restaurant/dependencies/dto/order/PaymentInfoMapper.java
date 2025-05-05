package com.restaurant.dependencies.dto.order;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.model.order.PaymentInfo;
import org.springframework.stereotype.Component;

@Component
public class PaymentInfoMapper implements DtoTransformable<PaymentInfoDto, PaymentInfo> {

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
