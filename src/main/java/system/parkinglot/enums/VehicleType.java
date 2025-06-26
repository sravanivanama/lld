package system.parkinglot.enums;

import system.parkinglot.exception.InvalidVehicle;
import system.parkinglot.pojo.Vehicle;

import java.util.Arrays;

public enum VehicleType {
    CAR, BIKE, TRUCK;

    public static VehicleType getVehicleType(String vehicle) throws Exception{
        VehicleType vehicleType = null;
        try {
            vehicleType = VehicleType.valueOf(vehicle);
            return vehicleType;
        } catch(IllegalArgumentException e){
            throw new InvalidVehicle("Provided Invalid Vehicle type: "+vehicle+
                    " .Supported Values are: "+ Arrays.toString(VehicleType.values()));
        }
    }
}
