package org.restaurant.order_compose_machine.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restaurant.order_compose_machine.enums.payment.PaymentMethod;
import org.restaurant.order_compose_machine.enums.payment.PaymentStatus;
import org.restaurant.order_compose_machine.model.money.Discount;
import org.restaurant.order_compose_machine.model.money.Price;
import org.restaurant.order_compose_machine.model.money.Tax;

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
