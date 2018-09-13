package service;

import org.springframework.web.bind.annotation.ControllerAdvice;

@SuppressWarnings("serial")
@ControllerAdvice
public class CustomerNotFoundException extends Exception {
  public CustomerNotFoundException() {}
  
  public CustomerNotFoundException(String message) {
    super(message);
  }
}
