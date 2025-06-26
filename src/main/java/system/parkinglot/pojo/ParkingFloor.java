package system.parkinglot.pojo;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class ParkingFloor {

    private static final Logger LOGGER = Logger.getLogger("ParkingFloor");
    int floorNumber;
    Map<ParkingSpot, Integer> parkingSpotMap;

    public ParkingFloor(int floor, Map<ParkingSpot, Integer>parkingSpotMap){
        this.floorNumber = floor;
        this.parkingSpotMap = parkingSpotMap;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Map<ParkingSpot, Integer> getParkingSpotMap() {
        return parkingSpotMap;
    }

    public void setParkingSpotMap(Map<ParkingSpot, Integer> parkingSpotMap) {
        this.parkingSpotMap = parkingSpotMap;
    }

    public int getAvailableSpots(ParkingSpot parkingSpot){
        return parkingSpotMap.get(parkingSpot);
    }

    public synchronized void decrementParkingSpot(ParkingSpot spot){
        LOGGER.info("Decrementing the no. of available parking spots for: "+spot.toString());
        parkingSpotMap.put(spot, parkingSpotMap.get(spot)-1);
        if(parkingSpotMap.get(spot) == 0){
            parkingSpotMap.remove(spot);
        }
    }
    public synchronized void incrementParkingSpot(ParkingSpot spot){
        LOGGER.info("Incrementing the no. of available parking spots for: "+spot.toString());
        parkingSpotMap.put(spot, parkingSpotMap.getOrDefault(spot, 0)+1);
    }
}
