package system.parkinglot.dao;

import system.parkinglot.pojo.ParkingTicket;

import java.util.ArrayList;
import java.util.List;

public class ParkingTicketDao {

    private static List<ParkingTicket> parkingTicketList;

    public static ParkingTicket getTicketById(int ticketId){
        ParkingTicket parkingTicket = null;
        if(parkingTicketList != null) {
             parkingTicket = parkingTicketList.stream().filter(pk -> pk.getTicketId() == ticketId).findFirst().orElse(null);
        }
        return parkingTicket;
    }

    public static void fillParkingTicketList(ParkingTicket parkingTicket){
        parkingTicketList.add(parkingTicket);
    }
}
