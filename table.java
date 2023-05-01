import java.util.*;
public class table {

    public int tableNumber;
    public int numberOfSeats;
    public String description;
    public Ticket tableTicket;
    public int status;
    /* 
    public int tabley;
    public int tablex;
    public int width;
    public int height;*/

    public table(int tNum, int sNum) { 
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
        this.status = 0;
        this.tableTicket = null;
        this.description = "";
        /* 
        //both coords are top left of table
        this.tabley = 0;
        this.tablex = 0;
        this.width = 10;
        this.height = 10;*/
    }

    public void setTableNumber(int tableNum) {
        if(tableNum <= 99 && tableNum >= 0) {
            this.tableNumber = tableNum;
            if(this.tableTicket != null){
                this.tableTicket.setTableNum(tableNum);
            }
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

    public void setTicket(Ticket t) {
        if(t.getTableNum() == this.tableNumber) {
            this.tableTicket = t;
        }
    }

    public int getTicketStatus() {
        return this.status;
    }
    
    public String getDescription() {
        return this.description;
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
    
    /* 
    public int setTableY() {
        return this.tabley;
    }

    public int setTableX() {
        return this.tablex;
    }

    public int setTableWidth() {
        return this.width;
    }

    public int setTableHeight() {
        return this.height;
    }

    public int getTableY() {
        return this.tabley;
    }

    public int getTableX() {
        return this.tablex;
    }

    public int getTableWidth() {
        return this.width;
    }

    public int getTableHeight() {
        return this.height;
    }
    */
}
