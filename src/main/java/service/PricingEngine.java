package service;

import bean.Order;
/**
 * @author yan
 * @date 18-9-27 下午4:13
 */
public interface PricingEngine {
  public float calculateOrderTotal(Order order);
}
