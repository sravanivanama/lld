package system.parkinglot.service.payment;

import system.parkinglot.dto.PaymentRequest;
import system.parkinglot.enums.PaymentType;
import system.parkinglot.exception.UnsupportedPayment;

public class PaymentStrategyFactory {
    public static PaymentStrategy getStrategy(PaymentRequest paymentRequest) throws Exception{
        PaymentType type = PaymentType.getPaymentType(paymentRequest.getPaymentType());
        switch(type){
            case DEBIT_CARD:
                return new DebitCardPaymentStrategy(
                        paymentRequest.getName(), paymentRequest.getCardNumber(), paymentRequest.getMonthOfExpiry(), paymentRequest.getYearOfExpiry());
            case UPI: return new UPIPaymentStrategy(paymentRequest.getUpiId());
            default: throw new UnsupportedPayment("Unsupported payment type: "+paymentRequest.getPaymentType());
        }
    }
}
