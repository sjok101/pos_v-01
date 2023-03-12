import java.util.*;
public class table {

    public int tableNumber;
    public int numberOfSeats;
    public Ticket tableTicket;
     // may change to priority queue for the queue position

    public table(int tNum, int sNum) { 
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
        this.tableTicket = null;
    }

    public void setTableNumber(int tableNum) {
        if(tableNum >= 0) {
            this.tableNumber = tableNum;
            if(this.tableTicket != null){
                this.tableTicket.setTableNum(tableNum);
            }
        }  
    }

    public void setNumberOfSeats(int numSeats) {
        if(numSeats <= 50 && numSeats > 0) {
            this.numberOfSeats = numSeats;
        }
    }

    public void setTicket(Ticket t) {
        //check viab
        this.tableTicket = t;
    }

    public void makeTicket() {
        try {
            Ticket newTicket = new Ticket(this.tableNumber); // this.tableNumber <- param
            //do stuff
            this.tableTicket = newTicket;
        }
        catch(Exception e) {
            System.out.println(" something when wrong LOL");
        }
    }

    public Ticket getTicket() { //maybe ask for table number aswell          
        return this.tableTicket;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }
}
