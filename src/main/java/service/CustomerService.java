package service;
import bean.Customer;
/**
 * @author yan
 * @date 18-9-27 下午4:13
 */
public interface CustomerService {
   Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}