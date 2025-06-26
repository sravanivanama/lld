package system.parkinglot.pojo;

import system.parkinglot.enums.VehicleType;

public class ParkingTicket {
    long ticketId;
    long currTimestamp;
    String vehicleNo;
    VehicleType vehicleType;

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    int floorNo;


    public ParkingTicket(long ticketId, String vehicleNo, VehicleType vehicleType, long currTimestamp, int floorNo) {
        this.ticketId = ticketId;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.currTimestamp = currTimestamp;
        this.floorNo = floorNo;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getCurrTimestamp() {
        return currTimestamp;
    }

    public void setCurrTimestamp(long currTimestamp) {
        this.currTimestamp = currTimestamp;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
