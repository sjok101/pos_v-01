
import java.util.*;


//waiting for ui functions to continue
public class kitchen {
    private LinkedList<kitchenTicket> ktickets = null;


    public kitchen() { //Constructor?
        this.ktickets = new LinkedList<kitchenTicket>();
        
    }
    
    public LinkedList<kitchenTicket> getKitchenTickets() {
        return this.ktickets;
    }

    public LinkedList<kitchenTicket> setKitchenTickets() {
        return this.ktickets;
    }

    public void ticketsToKitchenTickets(LinkedList<Ticket> tickets) {
        System.out.println("here     " + tickets.size());
        String printedOrders = "";
        boolean firstIteration = true;
        for(Ticket t: tickets) {
            kitchenTicket k = new kitchenTicket();
            k.setCreationTime(t.getCreationTime().toString());
            k.setPriority(t.getPriority());
            k.settableNum(t.getTableNum());
            k.setTicketid(t.getTicketID());
            HashMap<Integer,LinkedList<Order>> o = t.getOrders();
            System.out.println("here 2  " + o.size());
            for(LinkedList<Order> orders: o.values()) {
                System.out.println("here 3  " + orders.size());
                for(Order order: orders) {
                System.out.println("here 4");
                    if(order.getDishes() != null) {
                        LinkedList<Dish> d = order.getDishes();
                        for(Dish dish: d) {
                            System.out.println("here 5");
                            if(dish.getName() != null) {
                                if(firstIteration == false) {
                                    printedOrders +=";";
                                }
                                if(dish.getDescription() != null) {
                                    printedOrders += dish.getName() + "," + dish.getDescription();
                                }
                                else {
                                    printedOrders += dish.getName();
                                }
                            }
                            firstIteration = false;
                        }
                    }
               }
            }
            firstIteration = true;
            k.setOrderString(printedOrders);
            printedOrders = "";
            this.ktickets.add(k);
        }  
        
    }

    public void completeTicket(int ticketID) {
        for(kitchenTicket k: ktickets) {
            if(k.getTicketid() == ticketID) {
                this.ktickets.remove(k);
                break; 
            }
        }
    }


}
