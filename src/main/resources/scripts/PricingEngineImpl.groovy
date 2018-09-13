import service.PricingEngine

import java.io.Serializable;

class PricingEngineImpl implements PricingEngine, Serializable {
  public float calculateOrderTotal(bean.Order order) {
    print "IN GROOVY";
  
    retun 99.99;
  }
}
