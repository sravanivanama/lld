package system.parkinglot.pojo;

import java.util.Map;

public class ParkingLot {
    private int totalFloors;
    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingLot(int totalFloors, Map<Integer, ParkingFloor> parkingFloorMap) {
        this.totalFloors = totalFloors;
        this.parkingFloorMap = parkingFloorMap;
    }

    public ParkingLot() {

    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public Map<Integer, ParkingFloor> getParkingFloorMap() {
        return parkingFloorMap;
    }

    public void setParkingFloorMap(Map<Integer, ParkingFloor> parkingFloorMap) {
        this.parkingFloorMap = parkingFloorMap;
    }
}
