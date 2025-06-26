package system.parkinglot.pojo;

import system.parkinglot.enums.VehicleType;
import system.parkinglot.exception.InvalidVehicle;

import static system.parkinglot.enums.VehicleType.*;

public class ParkingSpot {
    public static ParkingSpot getParkingSpotByVehicle(VehicleType vehicleType) throws InvalidVehicle {
        switch(vehicleType) {
            case CAR:
                return new CarSpot();
            case BIKE:
                return new BikeSpot();
            case TRUCK:
                return new TruckSpot();
            default:
                throw new InvalidVehicle("Invalid vehicle received");
        }
    }
}
