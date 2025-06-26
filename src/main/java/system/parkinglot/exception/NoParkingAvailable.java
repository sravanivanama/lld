package system.parkinglot.exception;

public class NoParkingAvailable extends Exception{
    String message;
    public NoParkingAvailable(String message){
        this.message = message;
    }
}
