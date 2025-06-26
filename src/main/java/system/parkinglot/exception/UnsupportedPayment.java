package system.parkinglot.exception;

public class UnsupportedPayment extends Exception{
    String message;
    public UnsupportedPayment(String msg){
        this.message = msg;
    }
}
