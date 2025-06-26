package system.parkinglot.service.payment;

import system.parkinglot.dao.ParkingTicketDao;
import system.parkinglot.dto.PaymentRequest;
import system.parkinglot.enums.VehicleType;
import system.parkinglot.exception.InvalidTicket;
import system.parkinglot.pojo.ParkingFloor;
import system.parkinglot.pojo.ParkingSpot;
import system.parkinglot.pojo.ParkingTicket;
import system.parkinglot.service.ParkingLotService;
import system.parkinglot.service.PaymentFare;

import java.util.logging.Logger;

import static system.parkinglot.constants.NumericConstants.SEC_TO_HOUR;

public class PaymentService {

    private static final Logger LOGGER = Logger.getLogger("PaymentService");

    ParkingLotService parkingLotService = new ParkingLotService();

    public void payment(PaymentRequest paymentRequest) throws Exception{
        // Create a payment request from details
        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getStrategy(paymentRequest);
        ParkingTicket parkingTicket = ParkingTicketDao.getTicketById(paymentRequest.getTicketId());
        if(parkingTicket == null){
            throw new InvalidTicket("Invalid TicketId: "+paymentRequest.getTicketId()+". Please provide a valid one");
        }
        double amount = calculateFare(parkingTicket.getCurrTimestamp(), parkingTicket.getVehicleType());
        paymentStrategy.pay(amount);

        // Increment the space as vehicle now is exiting
        ParkingFloor floor = parkingLotService.getParkingFloor(parkingTicket.getFloorNo());
        ParkingSpot spot = ParkingSpot.getParkingSpotByVehicle(parkingTicket.getVehicleType());
        floor.incrementParkingSpot(spot);


    }

    private double calculateFare(long timestamp, VehicleType vehicleType){
        double baseFare = PaymentFare.parkingFareHourlyMap.get(vehicleType);
        long hours = (System.currentTimeMillis() - timestamp)/SEC_TO_HOUR;
        double fare = baseFare * hours;
        LOGGER.info("");
        return fare;
    }
}
