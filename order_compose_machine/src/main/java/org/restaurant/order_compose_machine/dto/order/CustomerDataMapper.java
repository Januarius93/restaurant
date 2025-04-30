package org.restaurant.order_compose_machine.dto.order;

import org.restaurant.order_compose_machine.dto.DtoTransformable;
import org.restaurant.order_compose_machine.model.CustomerData;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataMapper implements DtoTransformable<CustomerDataDto, CustomerData> {

  private final AddressMapper addressMapper;
  private final CustomerMapper customerMapper;

  public CustomerDataMapper(AddressMapper addressMapper, CustomerMapper customerMapper) {
    this.addressMapper = addressMapper;
    this.customerMapper = customerMapper;
  }

  @Override
  public CustomerDataDto toDto(CustomerData customerData) {
    return CustomerDataDto.builder()
        .customer(customerMapper.toDto(customerData.getCustomer()))
        .address(addressMapper.toDto(customerData.getAddress()))
        .build();
  }

  @Override
  public CustomerData toEntity(CustomerDataDto customerDataDto) {
    CustomerData customerData = new CustomerData();
    customerData.setCustomer(customerMapper.toEntity(customerDataDto.getCustomer()));
    customerData.setAddress(addressMapper.toEntity(customerDataDto.getAddress()));
    return customerData;
  }
}
