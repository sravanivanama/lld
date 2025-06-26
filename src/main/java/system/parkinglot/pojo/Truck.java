package system.parkinglot.pojo;

import system.parkinglot.enums.VehicleType;

public class Truck extends Vehicle{
    VehicleType getVehicle(){
        return VehicleType.TRUCK;
    }
}
