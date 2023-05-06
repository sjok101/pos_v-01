
import java.util.*;


//waiting for ui functions to continue
public class kitchen {
    private LinkedList<kitchenTicket> ktickets = null;


    public kitchen() { 
        this.ktickets = new LinkedList<kitchenTicket>();
    }

    public kitchen(LinkedList<kitchenTicket> kt) { 
        this.ktickets = kt;
    }
    
    public LinkedList<kitchenTicket> getKitchenTickets() {
        if(this.ktickets == null) {
            return null;
        }
        else if(this.ktickets.size() <= 0) {
            return null;
        }
        return this.ktickets;
    }

    public void setKitchenTickets(LinkedList<kitchenTicket> k) {
        this.ktickets = k;
    }

    public void ticketsToKitchenTickets(LinkedList<Ticket> tickets) {
        if(tickets != null) {
            String printedOrders = "";
            boolean firstIteration = true;
            for(Ticket t: tickets) {
                kitchenTicket k = new kitchenTicket();
                k.setCreationTime(t.getCreationTime().toString());
                k.setPriority(t.getPriority());
                k.settableNum(t.getTableNum());
                k.setTicketid(t.getTicketID());
                LinkedList<Dish> d = t.getDishes();
                for(Dish dish: d) {
                    if(dish.getName() != null) {
                        if(firstIteration == false) {
                            printedOrders +=",";
                        }
                        printedOrders += dish.getName();
                        
                    }
                    firstIteration = false;
                }   
                firstIteration = true;
                k.setOrderString(printedOrders);
                printedOrders = "";
                this.ktickets.add(k);
            }
        }      
    }
}
