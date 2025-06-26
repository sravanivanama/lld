package system.parkinglot.service.payment;

import java.util.logging.Logger;

public class DebitCardPaymentStrategy implements PaymentStrategy{
    private static final Logger LOGGER = Logger.getLogger("DebitCardPaymentStrategy");
    String name;
    String cardNumber;
    int monthOfExpiry;
    int yearOfExpiry;


    public DebitCardPaymentStrategy(String name, String cardNumber, int monthOfExpiry, int yearOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.monthOfExpiry = monthOfExpiry;
        this.yearOfExpiry = yearOfExpiry;
    }

    public void pay(double amount) {
        LOGGER.info("Initiating payment via DebitCard for user: "+name+ " ,amount: "+amount);
        LOGGER.info("Completed payment via DebitCard for user: "+name+ " ,amount: "+amount);

    }

}
