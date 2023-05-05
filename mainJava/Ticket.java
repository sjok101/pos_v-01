
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;



import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

enum Ticketstatus{
    OPEN,
    CLOSED;
}

class Ticket {
    private int tableNum;
    private int ticketID;
    private double total;
    private String creationTime;
    private String closingTime;
    private Ticketstatus status;
    private int priority;
    private LinkedList<Order> orders;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  

    //constructor for Ticket
    public Ticket(int tblnum){
        this.tableNum = tblnum;
        LocalDateTime now = LocalDateTime.now();
        this.creationTime = dtf.format(now);
        this.orders = new LinkedList<Order>();
    }

    public Ticket(int tblnum, LinkedList<Order> ordrs){
        this.tableNum = tblnum;
        LocalDateTime now = LocalDateTime.now();
        this.creationTime = dtf.format(now);
        this.orders = ordrs;
    }

    // getters/setters

    public void setTableNum(int tn){
        this.tableNum = tn;
    }

    public void setTicketID(int id){
        this.ticketID = id;
    }

    public void setTotal(double tot){
        this.total = tot;
    }

    public void setpriority(int p){
        this.priority = p;
    }

    public void setStatus(Ticketstatus ts){
        this.status = ts;
    }

    public int getTableNum(){
        return this.tableNum;
    }

    public int getTicketID(){
        return this.ticketID;
    }

    public double getTotal(){
        return this.total;
    }

    public String getCreationTime(){
        return this.creationTime;
    }

    public int getPriority(){
        return this.priority;
    }

    public Ticketstatus getStatus(){
        return this.status;
    }

    public String getClosingTime(){
        return this.closingTime;
    }

    public LinkedList<Order> getOrders(){
        return this.orders;
    }

    //adds order to ticket
    public boolean addOrder(int seatnum, Order ordr){
        this.total += ordr.getTotal();
        return this.orders.add(ordr);
    }

    //remove order for ticket (void) TODO: manager verification?
    public boolean removeOrder(int seatnum, Order ordr){
        if(this.orders == null){
            return false;
        }
        if(this.orders.remove(ordr) == true){
            this.total -= ordr.getTotal();
            return true;
        }
        return false;
    }
    
    //method to close ticket. Sets closing time 
    public void closeTicket(){
        LocalDateTime now = LocalDateTime.now();
        this.closingTime = dtf.format(now);
        this.status = Ticketstatus.CLOSED;
    }

}
