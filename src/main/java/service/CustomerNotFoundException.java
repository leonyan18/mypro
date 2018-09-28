package service;


/**
 * @author yan
 * @date 18-9-27 下午4:13
 * @descripition 捕捉没有找到客户异常
 */
public class CustomerNotFoundException extends Exception {
  public CustomerNotFoundException() {}
  
  public CustomerNotFoundException(String message) {
    super(message);
  }
}
