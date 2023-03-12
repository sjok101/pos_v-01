import java.util.*;

public class kitchen {

    public LinkedList<Ticket> tickets = null;


    public kitchen() { //Constructor?
        this.tickets = new LinkedList<Ticket>();
    }


    public String printOrders() {
        String printedOrders = "";
        /* 
        for(Ticket t: tickets) {
            for(order o: t.getOrders();) {

            }      
        }
        */
        return printedOrders;
    }

    public boolean completeTicket(Ticket t) {
        Boolean completed = this.tickets.remove(t);
        return completed;
    }


}
