import java.time.format.DateTimeFormatter;
import java.math.*;
import java.math.*;
import java.time.LocalDateTime;
import java.util.LinkedList;

//node of ticket linked list

public class Order {
    private int tableNum;
    private int orderID;
    private double total;
    private String creationTime;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
    private LinkedList<Dish> dishes;

    //constructor for Ticket
    public Order(int tblnum){
        if(tblnum < 0){
            throw new IndexOutOfBoundsException("Error! tablenum for order must be >= 0");
        }
        this.tableNum = tblnum;
        LocalDateTime now = LocalDateTime.now();
        this.creationTime = dtf.format(now);
        this.dishes = new LinkedList<>();
        this.total = 0;
        this.total = 0;
    }

    //getters and setters

    public double getTotal(){
        return this.total;
    }

    public int getTableNum(){
        return this.tableNum;
    }

    public int getOrderID(){
        return this.orderID;
    }

    public String getCreationTime(){
        return this.creationTime;
    }

    public String getCreationTime(){
        return this.creationTime;
    }

    public LinkedList<Dish> getDishes(){
        return this.dishes;
    }

    public void setOrderID(int ID){
        if(ID < 0){
            throw new IndexOutOfBoundsException("Error! ID must be >= 0");
        }
        this.orderID = ID;
    }

    public void setToatl(double tot){
        if(tot >= 0){
            this.total = round(tot, 2);
        }
        else{
            throw new IndexOutOfBoundsException("Error: Total must be greater than or equal to 0.");
        }
    }

    public void setTableNum(int tblnum){
        if(tblnum <= 0){
            throw new IndexOutOfBoundsException("Error! table number must be >=0");
        }
        this.tableNum = tblnum;
    }

    //add dish to order
    public boolean addDish(Dish d){
        if(d == null){
            throw new NullPointerException("Error! dish passed is null!");
        }
        if(this.dishes.add(d) == true){
            this.total += d.getPrice();
            return true;
        }
        return false;
    }

    //remove dish from order
    public boolean removeDish(Dish d){
        if(this.dishes.remove(d) == true){
            this.total -= d.getPrice();
            return true;
        }
        return false;
    }

    //helper function to round a price to 2 deciaml palces
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    //helper function to round a price to 2 deciaml palces
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}