package system.parkinglot.service;

import system.parkinglot.dao.ParkingTicketDao;
import system.parkinglot.enums.VehicleType;
import system.parkinglot.pojo.ParkingFloor;
import system.parkinglot.pojo.ParkingLot;
import system.parkinglot.pojo.ParkingSpot;
import system.parkinglot.pojo.ParkingTicket;

import java.util.logging.Logger;

public class ParkingTicketService {

    public static final Logger LOGGER = Logger.getLogger("ParkingTicketService");
    ParkingLotService parkingLotService = new ParkingLotService();

    public ParkingTicket issueTicket(String vehicleNo, String vehicle) throws Exception {
        LOGGER.info("Start of issuing ticket for vehicle type:"+ vehicle + " , vehicleNo.: "+vehicleNo);
        VehicleType vehicleType = VehicleType.getVehicleType(vehicle);
        ParkingSpot parkingSpot = ParkingSpot.getParkingSpotByVehicle(vehicleType);
        int ticketId = TicketIdGenerator.incrementId();
        int floorToPark = parkingLotService.getParkingFloorToPark(vehicle);
        ParkingTicket parkingTicket = new ParkingTicket(ticketId, vehicleNo, vehicleType, System.currentTimeMillis(), floorToPark);
        // Decrement parking spot of this type
        ParkingTicketDao.fillParkingTicketList(parkingTicket);
        ParkingFloor parkingFloor = parkingLotService.getParkingFloor(floorToPark);
        parkingFloor.decrementParkingSpot(parkingSpot);
        return parkingTicket;
    }

}
