package system.parkinglot.service;

public class TicketIdGenerator {
    static int id = 0;

    public static synchronized int incrementId(){
        ++id;
        return id;
    }
}
