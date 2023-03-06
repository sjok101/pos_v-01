import java.util.*;
public class table {

    private int tableNumber;
    private int numberOfSeats;
    private int numberOfCustomers;
    private int ticketID;
    private int queuePosition;
    private HashMap<Integer,ticket> seats = null;
    private LinkedList<table> tables = new LinkedList<table>(); // may change to priority queue for the queue position

    public table(int tNum, int sNum) { //constructor?

        this.seats = new HashMap<Integer,ticket>();
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
        this.numberOfCustomers = 0;
        this.queuePosition = -1;
    }

    public void makeTable(int tNum,int sNum) {
        table t = new table(tNum,sNum);
        tables.add(t);
    }

    public void adjustTable(int tableNumber) { 
        //get table from list
        //loop for choice
        //choices (change num of seat, table num, num of customers, or queue position)
        //loop for increment, decrement, or exit out of the choice
        //leave loop choice to leave editing mode
    }

    public ticket makeTicket(int seatNumber) {
        ticket newTicket = new ticket();
        //sends to ticket system and get the returned data for the table
        return newTicket;
    }

    public void removeCustomer(int tableNumber) {
        //remove customer from table
    }

    public void addCustomer(int tableNumber) {
        //add customer to table
    }

    public ticket getTicket(int seatNumber) { //maybe ask for table number aswell    
        return seats.get(seatNumber);
    }

}
