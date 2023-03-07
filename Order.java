import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.LinkedList;

//node of ticket linked list

public class Order {
    private int tableNum;
    private int orderID;
    private double total;
    private String creationTime;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
    private LinkedList<Dish> dishes;

    //constructor for Ticket
    public Order(int tblnum){
        this.tableNum = tblnum;
        LocalDateTime now = LocalDateTime.now();
        this.creationTime = dtf.format(now);
        this.dishes = new LinkedList<>();
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

    public LinkedList<Dish> getDishes(){
        return this.dishes;
    }

    //add dish to order
    public boolean addDish(Dish d){
        if(this.dishes.add(d) == true){
            //TODO: NEED INTEGRATION WITH dish.java HERE
            this.total += d.getPrice();
            return true;
        }
        return false;
    }

    //remove dish from order
    public boolean removeDish(Dish d){
        if(this.dishes.remove(d) == true){
            //TODO: NEED INTEGRATION WITH dish.java HERE
            this.total -= d.getPrice();
            return true;
        }
        return false;
    }
    }

}
