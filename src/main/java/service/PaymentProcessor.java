package service;


/**
 * @author wallsc
 * @date 18-9-27 下午4:13
 * @descripition 支付过程
 */
public class PaymentProcessor {
   public PaymentProcessor() {}

   public void approveCreditCard(String creditCardNumber, String expMonth,
                     String expYear, float amount) throws PaymentException {
      if (amount > 20.00) {
         throw new PaymentException();
      }
   }
}
