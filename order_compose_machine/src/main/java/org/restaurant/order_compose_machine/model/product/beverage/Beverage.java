package org.restaurant.order_compose_machine.model.product.beverage;

import org.restaurant.order_compose_machine.enums.product.AlcoholContent;
import org.restaurant.order_compose_machine.enums.product.SugarLevel;
import org.restaurant.order_compose_machine.enums.product.TemperatureCategory;

public abstract class Beverage {
  private AlcoholContent alcoholContent;
  private SugarLevel sugarLevel;
  private TemperatureCategory temperatureCategory;
  private Double volume;
}
