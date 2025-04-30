package org.restaurant.order_compose_machine.dto.order;

import org.restaurant.order_compose_machine.dto.DtoTransformable;
import org.restaurant.order_compose_machine.model.person.Customer;
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
