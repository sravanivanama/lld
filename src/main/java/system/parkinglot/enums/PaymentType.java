package system.parkinglot.enums;

import system.parkinglot.exception.UnsupportedPayment;

import java.util.Arrays;

public enum PaymentType {
    DEBIT_CARD, UPI, PAYTM;

    public static PaymentType getPaymentType(String type) throws Exception {
        PaymentType paymentType = null;
        try {
            paymentType = PaymentType.valueOf(type);
            return paymentType;
        } catch(IllegalArgumentException e){
            throw new UnsupportedPayment("Unsupported payment type: "+type+
                    " . Supported methods are: "+ Arrays.asList(PaymentType.values()));

        }
    }
}
