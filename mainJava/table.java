
public class table {

    public int tableNumber;
    public int numberOfSeats;
    public String description;
    public int tableTicketID;
    public String status;

    public table() { 
        this.tableNumber = 0;
        this.numberOfSeats = 0;
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
        }  
    }

    public void setTableDescription(String description) {
            this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
        
    }

    public void setNumberOfSeats(int numSeats) {
        if(numSeats <= 100 && numSeats >= 0) {
            this.numberOfSeats = numSeats;
        }
    }

    public void setTicket(int t) {
        if(t >= 0) {
            this.tableTicketID = t;
        }
    }

    public String getStatus() {
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
