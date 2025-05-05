package com.restaurant.dependencies.dto.order;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements DtoTransformable<AddressDto, Address> {
  @Override
  public AddressDto toDto(Address address) {
    return AddressDto.builder()
        .city(address.getCity())
        .streetName(address.getStreetName())
        .streetNumber(address.getStreetNumber())
        .homeNumber(address.getHomeNumber())
        .postalCode(address.getPostalCode())
        .build();
  }

  @Override
  public Address toEntity(AddressDto addressDto) {
    Address address = new Address();
    address.setCity(addressDto.getCity());
    address.setStreetName(addressDto.getStreetName());
    address.setStreetNumber(addressDto.getStreetNumber());
    address.setHomeNumber(addressDto.getHomeNumber());
    address.setPostalCode(addressDto.getPostalCode());
    return address;
  }
}
