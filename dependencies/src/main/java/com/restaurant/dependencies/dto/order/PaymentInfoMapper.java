package com.restaurant.dependencies.dto.order;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.model.order.PaymentInfo;
import org.springframework.stereotype.Component;

@Component
public class PaymentInfoMapper  {

//  @Override
//  public PaymentInfoDto toDto(PaymentInfo paymentInfo) {
//    return PaymentInfoDto.builder()
//        .price(paymentInfo.getPrice())
//        .paymentMethod(paymentInfo.getPaymentMethod())
//        .paymentStatus(paymentInfo.getPaymentStatus())
//        .build();
//  }
//
//  @Override
//  public PaymentInfo toEntity(PaymentInfoDto paymentInfoDto) {
//    PaymentInfo paymentInfo = new PaymentInfo();
//    paymentInfo.setPrice(paymentInfoDto.getPrice());
//    paymentInfo.setPaymentMethod(paymentInfoDto.getPaymentMethod());
//    paymentInfo.setPaymentStatus(paymentInfoDto.getPaymentStatus());
//    return paymentInfo;
//  }
}
