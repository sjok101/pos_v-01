package mainJava;
import java.util.*;
public class table {

    public int tableNumber;
    public int numberOfSeats;
    public String description;
    public int tableTicketID;
    public int status;

    public table(int tNum, int sNum) { 
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
        this.status = 0;
        this.tableTicketID = 0;
        this.description = "";
    }

    public table(int tNum, int sNum,int status,int tableTicketID,String description) { 
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
        this.status = status;
        this.tableTicketID = tableTicketID;
        this.description = description;
    }

    public void setTableNumber(int tableNum) {
        if(tableNum <= 99 && tableNum >= 0) {
            this.tableNumber = tableNum;
        }  
    }

    public void setTableDescription(String description) {
            this.description = description;
    }

    public void setTableTicketStatus(int status) {
        if(status >= 0 && status <= 5) {
            this.status = status;
        }
    }

    public void setNumberOfSeats(int numSeats) {
        if(numSeats <= 50 && numSeats >= 0) {
            this.numberOfSeats = numSeats;
        }
    }

    public void setTicket(int t) {
        this.tableTicketID = t;
    }

    public int getTicketStatus() {
        return this.status;
    }
    
    public String getDescription() {
        return this.description;
    }

    public int getTicket() {          
        return this.tableTicketID;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }
}
