package org.restaurant.order_compose_machine.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    @JsonProperty("city")
    private String city;

    @JsonProperty("streetName")
    private String streetName;

    @JsonProperty("streetNumber")
    private Integer streetNumber;

    @JsonProperty("homeNumber")
    private Integer homeNumber;

    @JsonProperty("postalCode")
    private String postalCode;
}
