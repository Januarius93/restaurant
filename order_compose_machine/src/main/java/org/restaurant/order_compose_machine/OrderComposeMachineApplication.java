package org.restaurant.order_compose_machine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "com.restaurant.dependencies.model")
@ComponentScan(
    basePackages = {
      "org.restaurant.order_compose_machine",
      "com.restaurant.dependencies.dto",
      "com.restaurant.dependencies.model"
    })
public class OrderComposeMachineApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrderComposeMachineApplication.class, args);
  }
}
