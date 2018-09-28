package service;

import org.apache.log4j.Logger;

import bean.Order;
import org.springframework.stereotype.Service;
/**
 * @author yan
 * @date 18-9-27 下午4:13
 */
@Service
public class OrderServiceImpl {
  private static final Logger LOGGER = 
      Logger.getLogger(OrderServiceImpl.class);
  
  public OrderServiceImpl() {}
  
  public void saveOrder(Order order) {
    LOGGER.debug("SAVING ORDER:  " );
    LOGGER.debug("   Customer:  " + order.getCustomer().getName());
    LOGGER.debug("   # of Pizzas:  " + order.getPizzas().size());
    LOGGER.debug("   Payment:  " + order.getPayment());
  }
}
