package system.parkinglot.pojo;

import system.parkinglot.enums.VehicleType;

public class Bike extends Vehicle{
    VehicleType getVehicle(){
        return VehicleType.BIKE;
    }
}
