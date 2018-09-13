package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import service.PricingEngine;
import service.PricingEngineImpl;

public class Order implements Serializable {
   private static final long serialVersionUID = 1L;
   private Customer customer;
   private List<Pizza> pizzas;
   private Payment payment;

   public Order() {
      setPricingEngine(new PricingEngineImpl());
      pizzas = new ArrayList<Pizza>();
      customer = new Customer();
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public List<Pizza> getPizzas() {
      return pizzas;
   }

   public void setPizzas(List<Pizza> pizzas) {
      this.pizzas = pizzas;
   }

   public void addPizza(Pizza pizza) {
      pizzas.add(pizza);
   }

   public float getTotal() {
      return pricingEngine.calculateOrderTotal(this);
   }

   public Payment getPayment() {
      return payment;
   }

   public void setPayment(Payment payment) {
      this.payment = payment;
   }

   private PricingEngine pricingEngine;
   public void setPricingEngine(PricingEngine pricingEngine) {
      this.pricingEngine = pricingEngine;
   }
   public PricingEngine getPricingEngine() {
      return pricingEngine;
   }

}
