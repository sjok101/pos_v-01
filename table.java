import java.util.*;
public class table {

    private int tableNumber;
    private int numberOfSeats;
    private ticket ticket;
     // may change to priority queue for the queue position

    public table(int tNum, int sNum) { 
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
        this.ticket = null;
    }

    public void setTableNumber(int tableNum) {
        this.tableNumber = tableNum;
    }

    public void setNumberOfSeats(int numSeats) {
        if(numSeats > 50 && numSeats < 1) {
            
        }
        else {
            this.numberOfSeats = numSeats;
        }
    }

    public void setTicket(ticket t) {
        //check viab
        this.ticket = t;
    }

    public void makeTicket() {
        try {
            ticket newTicket = new ticket(); // this.tableNumber <- param
            //do stuff
            this.ticket = newTicket;
        }
        catch(Exception e) {
            System.out.println(" something when wrong LOL");
        }
    }

    public ticket getTicket() { //maybe ask for table number aswell          
        return this.ticket;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }
}
