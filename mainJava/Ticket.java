import java.util.Hashtable;
import java.util.LinkedList;
import java.time.format.DateTimeFormatter;
import java.math.*;
import java.time.LocalDateTime;

enum Ticketstatus{
    OPEN,
    CLOSED;
}

class Ticket{

    static final int TOGOTABLENUM = 99;

    private int tableNum;
    private int ticketID;
    private double total;
    private String creationTime;
    private String closingTime;
    private Ticketstatus status;
    private boolean togo;
    private int priority;
    //private LinkedList<Order> orders;
    private LinkedList<Dish> dishes;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  


    //TODO: MAIN MUST CALCULATE UNIQUE TICKET ID



    //constructor for Ticket
    public Ticket(int tblnum){
        if(tblnum <= 0){
            throw new IndexOutOfBoundsException("Error: TablenNum must be greater than 0.");
        }
        else{
            if(tblnum != TOGOTABLENUM){
                togo = false;
            }
            else{
                togo = true;
            }
            this.tableNum = tblnum;
            LocalDateTime now = LocalDateTime.now();
            this.creationTime = dtf.format(now);
            this.dishes = new LinkedList<Dish>();
            this.total = 0;
        }
    }

    public Ticket(int tblnum, LinkedList<Dish> ordrs){
        if(tblnum <= 0){
            throw new IndexOutOfBoundsException("Error: TablenNum must be greater than 0.");
        }
        if(ordrs == null){
            throw new NullPointerException("Error: order passed to constructor is null");
        }
        else{
            if(tblnum != TOGOTABLENUM){
                togo = false;
            }
            else{
                togo = true;
            }
            this.tableNum = tblnum;
            LocalDateTime now = LocalDateTime.now();
            this.creationTime = dtf.format(now);
            this.dishes = ordrs;
            this.total = 0;
        }
    }

    // getters/setters

    public void setTableNum(int tn){
        if(tn > 0){
            this.tableNum = tn;
            if(tn == TOGOTABLENUM){
                this.togo = true;
            }
            else{
                this.togo = false;
            }
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
            this.total = round(tot, 2);
        }
        else{
            throw new IndexOutOfBoundsException("Error: Total must be greater than or equal to 0.");
        }
    }

    public void setPriority(int p){
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

    public LinkedList<Dish> getDishes(){
        return this.dishes;
    }

    public boolean getTogo(){
        return this.togo;
    }


    //adds order to ticket
    public boolean addDish(Dish ordr){
        if(ordr != null){
            this.dishes.add(ordr);
            this.total += ordr.getPrice();
            return true;
        }
        return false;
    }

    //remove order for ticket (void) TODO: manager verification?
    public boolean removeDish(Dish ordr){
        if(ordr != null){
            this.dishes.remove(ordr);
            this.total -= ordr.getPrice();
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

    //helper function to round a price to 2 deciaml palces
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public String dishesToString(){
        return this.dishes.toString();
    }    

}