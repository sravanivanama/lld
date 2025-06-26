package system.parkinglot.exception;
public class InvalidVehicle extends Exception{
    String msg;
    public InvalidVehicle(String message){
        this.msg = message;
    }
}
