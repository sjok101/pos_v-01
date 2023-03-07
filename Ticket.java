import java.util.Hashtable;
import java.util.LinkedList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class Ticket{
    private int tableNum;
    private int ticketid;
    private double total;
    private String creationTime;
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
        this.tableNum = tn;
    }

    public void setTicketID(int id){
        this.ticketid = id;
    }

    public void setTotal(double tot){
        this.total = tot;
    }

    public void setpriority(int p){
        this.priority = p;
    }

    public int getTableNum(){
        return this.tableNum;
    }

    public int getTicketID(){
        return this.ticketid;
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

    public Hashtable<Integer, LinkedList<Order>> getOrders(){
        return this.orders;
    }

    public boolean addOrder(int seatnum, Order ordr){
        if(this.orders.get(seatnum).size() == 0){
            LinkedList<Order> orderlist = new LinkedList<>();
            return orderlist.add(ordr);
        }
        return this.orders.get(seatnum).add(ordr);
    }

    public boolean removeOrder(int seatnum, Order ordr){
        if(this.orders.get(seatnum) == null){
            return false;
        }
        return this.orders.get(seatnum).remove(ordr);
    }
    


}
