package system.parkinglot.service;

import system.parkinglot.enums.VehicleType;
import system.parkinglot.enums.VehicleType.*;

import java.util.Map;
import java.util.HashMap;

import static system.parkinglot.enums.VehicleType.*;

public class PaymentFare {

    public static final Map<VehicleType, Double> parkingFareHourlyMap = new HashMap<>(){{
        put(BIKE, 50.0);
        put(CAR, 100.0);
        put(TRUCK, 150.0);
    }};
}
