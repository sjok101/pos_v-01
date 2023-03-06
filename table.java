import java.util.*;
public class table {
    
    int tableNumber;
    int numberOfSeats;
    int ticketID;
    int queuePosition;
    int seatNumber;
    HashMap<Integer,orders> table = new HashMap<Integer,orders>();

    public void makeTable() {

    }

    public void adjustTable(int tableNumber) {

    }

    public ticket makeTicket(int seatNumber) {
        ticket newTicket = new ticket();

        return newTicket;
    }

    public void removeCustomer(int seatNumber) {

    }

    public void addCustomer(int seatNumber) {

    }

}
