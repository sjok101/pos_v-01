import java.util.*;
public class table {

    public int tableNumber;
    public int numberOfSeats;
    public Ticket tableTicket;

    public table(int tNum, int sNum) { 
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
        this.tableTicket = null;
    }

    public void setTableNumber(int tableNum) {
        if(tableNum <= 99 && tableNum >= 0) {
            this.tableNumber = tableNum;
            if(this.tableTicket != null){
                this.tableTicket.setTableNum(tableNum);
            }
        }  
    }

    public void setNumberOfSeats(int numSeats) {
        if(numSeats <= 50 && numSeats >= 0) {
            this.numberOfSeats = numSeats;
        }
    }

    public void setTicket(Ticket t) {
        if(t.tableNum == this.tableNumber) {
            this.tableTicket = t;
        }
    }

    public Ticket getTicket() {          
        return this.tableTicket;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }
}
