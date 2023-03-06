import java.util.*;
public class table {

    private int tableNumber;
    private int numberOfSeats;
    private int ticketID;
    private int queuePosition;
    private int seatNumber;
    private HashMap<Integer,ticket> table = new HashMap<Integer,ticket>();

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
