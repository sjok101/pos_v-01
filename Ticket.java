import java.util.Hashtable;
import java.util.LinkedList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

enum Ticketstatus{
    OPEN,
    CLOSED;
}

class Ticket{
    private int tableNum;
    private int ticketID;
    private double total;
    private String creationTime;
    private String closingTime;
    private Ticketstatus status;
    private int priority;
    private Hashtable<Integer, LinkedList<Order>> orders;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  

    //constructor for Ticket
    public Ticket(int tblnum){
        this.tableNum = tblnum;
        LocalDateTime now = LocalDateTime.now();
        this.creationTime = dtf.format(now);
        this.orders = new Hashtable<>();
    }

    public Ticket(int tblnum, Hashtable<Integer, LinkedList<Order>> ordrs){
        this.tableNum = tblnum;
        LocalDateTime now = LocalDateTime.now();
        this.creationTime = dtf.format(now);
        this.orders = ordrs;
        this.orders = new Hashtable<>();
    }

    // getters/setters

    public void setTableNum(int tn){
        if(tn > 0){
            this.tableNum = tn;
        }
        else{
            throw new IndexOutOfBoundsException("Error: TablenNum must be greater than 0.");
        }
    }

    public void setTicketID(int id){
        if(id >= 0){
            this.ticketID = id; 
        }
        else{
            throw new IndexOutOfBoundsException("Error: TicketID must be greater than or equal to 0.");
        }
    }

    public void setTotal(double tot){
        if(tot >= 0){
            this.total = tot;
        }
        else{
            throw new IndexOutOfBoundsException("Error: Total must be greater than or equal to 0.");
        }
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

    public Hashtable<Integer, LinkedList<Order>> getOrders(){
        return this.orders;
    }

    //adds order to ticket
    public boolean addOrder(int seatnum, Order ordr){
        if(this.orders.get(seatnum).size() == 0){
            LinkedList<Order> orderlist = new LinkedList<>();
            this.total += ordr.getTotal();
            return orderlist.add(ordr);
        }
        this.total += ordr.getTotal();
        return this.orders.get(seatnum).add(ordr);
    }

    //remove order for ticket (void) TODO: manager verification?
    public boolean removeOrder(int seatnum, Order ordr){
        if(this.orders.get(seatnum) == null){
            return false;
        }
        if(this.orders.get(seatnum).remove(ordr) == true){
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
