package com.restaurant.dependencies.dto.order;

import com.restaurant.dependencies.dto.DtoTransformable;
import com.restaurant.dependencies.model.person.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements DtoTransformable<CustomerDto, Customer> {
  @Override
  public CustomerDto toDto(Customer customer) {
    return CustomerDto.builder()
        .name(customer.getName())
        .surname(customer.getSurname())
        .email(customer.getEmail())
        .phone(customer.getPhone())
        .build();
  }

  @Override
  public Customer toEntity(CustomerDto customerDto) {
    Customer customer = new Customer();
    customer.setName(customerDto.getName());
    customer.setSurname(customerDto.getSurname());
    customer.setEmail(customerDto.getEmail());
    customer.setPhone(customerDto.getPhone());
    return customer;
  }
}
