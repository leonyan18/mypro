package service;

import bean.Order;

public interface PricingEngine {
  public float calculateOrderTotal(Order order);
}
