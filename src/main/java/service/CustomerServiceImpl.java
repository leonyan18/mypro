package service;

import bean.Customer;
import org.springframework.stereotype.Service;
/**
 * @author yan
 * @date 18-9-27 下午4:13
 */
@Service
public class CustomerServiceImpl implements CustomerService {
  public CustomerServiceImpl() {}
  
  public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {
    if("9725551234".equals(phoneNumber)) {
      Customer customer = new Customer();
      customer.setId(123);
      customer.setName("Craig Walls");
      customer.setAddress("3700 Dunlavy Rd");
      customer.setCity("Denton");
      customer.setState("TX");
      customer.setZipCode("76210");
      customer.setPhoneNumber(phoneNumber);
      return customer;
    } else {
      throw new CustomerNotFoundException();
    }
  }
}
