package com.restaurant.dependencies.model.product.beverage;

import com.restaurant.dependencies.enums.product.AlcoholContent;
import com.restaurant.dependencies.enums.product.SugarLevel;
import com.restaurant.dependencies.enums.product.TemperatureCategory;

public abstract class Beverage {
  private AlcoholContent alcoholContent;
  private SugarLevel sugarLevel;
  private TemperatureCategory temperatureCategory;
  private Double volume;
}
