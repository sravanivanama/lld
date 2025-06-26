package system.parkinglot.pojo;

import system.parkinglot.enums.VehicleType;

public class Car extends Vehicle {
    VehicleType getVehicle(){
        return VehicleType.CAR;
    }
}
