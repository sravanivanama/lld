package payments;

import enums.PaymentSource;
import exception.InvalidPaymentSource;
import payments.CreditCardProcessor;
import payments.DebitCardProcessor;
import payments.PaymentProcessor;
import payments.UPIProcessor;

import static enums.PaymentSource.*;

public class PaymentSourceStratgey {
    PaymentSource source;
    public PaymentSourceStratgey(PaymentSource source){
        this.source = source;
    }
    public PaymentProcessor processor() throws Exception{
        switch (source) {
            case CREDIT_CARD:
               return new CreditCardProcessor();
            case DEBIT_CARD:
                return new DebitCardProcessor();
            case UPI:
                return new UPIProcessor();
            default:
                throw new InvalidPaymentSource("Invalid Payment Type selected");
        }
    }
}
