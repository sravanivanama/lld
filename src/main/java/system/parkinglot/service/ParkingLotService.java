package system.parkinglot.service;

import system.parkinglot.enums.VehicleType;
import system.parkinglot.exception.NoParkingAvailable;
import system.parkinglot.pojo.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingLotService {
    static ParkingLot parkingLot;
    Random random = new Random();
    public static void initParkingLot(){
        int floors = 10;
        Map<Integer, ParkingFloor> parkingFloorMap = new ConcurrentHashMap<>();
        for(int i=1;i<=floors;i++) {
            parkingFloorMap.put(i, new ParkingFloor(1, new ConcurrentHashMap<>() {{
                put(new CarSpot(), 30);
                put(new BikeSpot(), 80);
                put(new TruckSpot(), 5);
            }}));
        }
         parkingLot = new ParkingLot();
        parkingLot.setTotalFloors(floors);
        parkingLot.setParkingFloorMap(parkingFloorMap);
    }

    public Map<Integer, Integer> getAvailableParkingSpots(String vehicle) throws Exception{
        VehicleType vehicleType = VehicleType.getVehicleType(vehicle);
        ParkingSpot parkingSpot = ParkingSpot.getParkingSpotByVehicle(vehicleType);
        Map<Integer, ParkingFloor> parkingFloorMap = parkingLot.getParkingFloorMap();
        Map<Integer, Integer> availableSpots = new ConcurrentHashMap<>();
        for(Map.Entry<Integer, ParkingFloor> parkingFloorEntry: parkingFloorMap.entrySet()){
            availableSpots.put(parkingFloorEntry.getKey(), parkingFloorEntry.getValue().getAvailableSpots(parkingSpot));
        }
        if(!availableSpots.isEmpty()){
            throw new NoParkingAvailable("No parking available currently");
        }
        return availableSpots;
    }

    public int getParkingFloorToPark(String vehicle) throws Exception {
        Map<Integer, Integer> availableSpotsPerFloor = getAvailableParkingSpots(vehicle);
        return availableSpotsPerFloor.get(random.nextInt(availableSpotsPerFloor.size()));
    }

    public ParkingFloor getParkingFloor(int floor){
        return parkingLot.getParkingFloorMap().get(floor);
    }
}
