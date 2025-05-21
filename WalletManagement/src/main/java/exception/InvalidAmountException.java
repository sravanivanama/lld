package exception;

public class InvalidAmountException extends Exception {
    String message;
    public InvalidAmountException(String message){
        this.message  = message;
    }
}
