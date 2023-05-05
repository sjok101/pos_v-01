<<<<<<< HEAD

=======
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
import java.util.*;

//waiting for ui functions to continue
public class kitchen {

    public LinkedList<Ticket> tickets = null;


    public kitchen() { //Constructor?
        this.tickets = new LinkedList<Ticket>();
    }

    public void addTicket(Ticket t) {
        this.tickets.add(t);
    }

    public ArrayList<String> printTickets() {
        ArrayList<String> printedTickets = new ArrayList<String>();
        String printedOrders = "";
        boolean validOrder = false;
        for(Ticket t: tickets) {
            validOrder = false;
            printedOrders = t.getCreationTime() + ":" + t.getPriority() +":" +t.getTableNum() + ":" + t.getTotal();
            Hashtable<Integer,LinkedList<Order>> o = t.getOrders();
            Set<Integer> orderNumSet = o.keySet();
            for(int oNum: orderNumSet) {
               LinkedList<Order> orders = o.get(oNum);
               for(Order order: orders) {
                    if(order.getDishes() != null) {
                        printedOrders +=":" + order.getOrderID();
                        LinkedList<Dish> d = order.getDishes();
                        for(Dish dish: d) {
                            if(dish.getName() != null) {
                                validOrder = true;
                                printedOrders +=";";
                                if(dish.getDescription() == null) {
                                    printedOrders += dish.getName() + "," + dish.getDescription();
                                }
                                else {
                                    printedOrders += dish.getName();
                                }
                            }

                        }
                    }
               }
            }
            if(validOrder == true) {
                printedTickets.add(printedOrders);
            }
            printedOrders = "";
        }  
        return printedTickets;
    }

    public boolean completeTicket(Ticket t) {
        Boolean completed = this.tickets.remove(t);
        return completed;
    }


}
