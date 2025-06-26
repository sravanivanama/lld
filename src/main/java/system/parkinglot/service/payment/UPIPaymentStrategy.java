package system.parkinglot.service.payment;

import java.util.logging.Logger;

public class UPIPaymentStrategy implements PaymentStrategy {
    private static final Logger LOGGER = Logger.getLogger("UPIPaymentStrategy");
    private String upiId;

    public UPIPaymentStrategy(String upiId){
        this.upiId = upiId;
    }
    @Override
    public void pay(double amount) {
        LOGGER.info("Initiating payment via UPI for id: "+upiId+ " ,amount: "+amount);
        LOGGER.info("Completed payment via UPI for id: "+upiId+ " ,amount: "+amount);
    }
}
