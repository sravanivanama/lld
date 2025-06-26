package system.parkinglot.exception;

public class InvalidTicket extends Exception{
    String message;

    public InvalidTicket(String msg){
        this.message = msg;
    }
}
