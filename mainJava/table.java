<<<<<<< HEAD

=======
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
import java.util.*;
public class table {

    public int tableNumber;
    public int numberOfSeats;
    public String description;
<<<<<<< HEAD
    public Ticket tableTicket;
    public int status;
=======
    public int tableTicketID;
    public String status;
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c

    public table(int tNum, int sNum) { 
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
<<<<<<< HEAD
        this.status = 0;
        this.tableTicket = null;
        this.description = "";
    }

    public void setTableNumber(int tableNum) {
        if(tableNum <= 99 && tableNum >= 0) {
            this.tableNumber = tableNum;
            if(this.tableTicket != null){
                this.tableTicket.setTableNum(tableNum);
            }
=======
        this.status = "";
        this.tableTicketID = 0;
        this.description = "";
    }

    public table(int tNum, int sNum,String status,int tableTicketID,String description) { 
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
        this.status = status;
        this.tableTicketID = tableTicketID;
        this.description = description;
    }

    public void setTableNumber(int tableNum) {
        if(tableNum <= 99 && tableNum >= 0) {
            this.tableNumber = tableNum;
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
        }  
    }

    public void setTableDescription(String description) {
            this.description = description;
    }

<<<<<<< HEAD
    public void setTableTicketStatus(int status) {
        if(status >= 0 && status <= 5) {
            this.status = status;
        }
=======
    public void setStatus(String status) {
        this.status = status;
        
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
    }

    public void setNumberOfSeats(int numSeats) {
        if(numSeats <= 50 && numSeats >= 0) {
            this.numberOfSeats = numSeats;
        }
    }

<<<<<<< HEAD
    public void setTicket(Ticket t) {
        if(t.getTableNum() == this.tableNumber) {
            this.tableTicket = t;
        }
    }

    public int getTicketStatus() {
=======
    public void setTicket(int t) {
        this.tableTicketID = t;
    }

    public String getStatus() {
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
        return this.status;
    }
    
    public String getDescription() {
        return this.description;
    }

<<<<<<< HEAD
    public Ticket getTicket() {          
        return this.tableTicket;
=======
    public int getTicket() {          
        return this.tableTicketID;
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
