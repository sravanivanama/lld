package exception;

public class InvalidPaymentSource extends Exception{
    String message;
    public InvalidPaymentSource(String message){
        this.message = message;
    }
}
