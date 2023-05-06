import java.util.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class kitchenTest {
    kitchen k = null;
    LinkedList<Ticket> tickets = null;
    Ticket t1 = null;
    Ticket t2 = null;
    Ticket t3 = null;
    Ticket t4 = null;

    @Before
    public void setupTest() {
       
        tickets = new LinkedList<Ticket>();
        Dish d1 = new Dish("apples", 0);
        Dish d2 = new Dish("orange", 0);
        Dish d3 = new Dish("banna", 0);
        Dish d4 = new Dish("pie", 0);
        Dish d5 = new Dish("steak", 0);
        Dish d6 = new Dish("steak", 0);
        Dish d7 = new Dish("apples", 0);
        Dish d8 = new Dish("orange", 0);
        //ticket 1
        t1 = new Ticket(1);
        t1.addDish(d1);
        t1.addDish(d2);
        t1.addDish(d3);
        t1.addDish(d4);
        t1.addDish(d5);
        t1.addDish(d6);
        t1.addDish(d7);
  
        //ticket 2
        t2 = new Ticket(2);
        t2.addDish(d8);
        t2.addDish(d4);
        t2.addDish(d3);
        t2.addDish(d5);
        t2.addDish(d2);
        t2.addDish(d1);
        t2.addDish(d2);
        //ticket 3
        t3 = new Ticket(4);
        t3.addDish(d2);
        //ticket 4
        t4 = new Ticket(3);
    }

    @Test
    public void normalKitchenTest() { //print out orders 1
        //gets printed out order string and compares it to expected printout
        String orderString = "";
        k = new kitchen();
        tickets.add(t1);
        tickets.add(t2);
        k.ticketsToKitchenTickets(tickets);
        LinkedList<kitchenTicket> kit = k.getKitchenTickets();
        for(int i = 0; kit.size() > i; i++) {
            if(i == 0) {
                orderString = kit.get(i).getOrderString();
                assertEquals(orderString, "apples,orange,banna,pie,steak,steak,apples");
            }
            else if(i == 1) {
                orderString = kit.get(i).getOrderString();
                assertEquals(orderString, "orange,pie,banna,steak,orange,apples,orange");
            }
        }
    }

    @Test
    public void singleOrderTest() { //printout kitchen 2
        String orderString = "";
        k = new kitchen();
        tickets.add(t3);
        k.ticketsToKitchenTickets(tickets);
        LinkedList<kitchenTicket> kit = k.getKitchenTickets();
        orderString = kit.get(0).getOrderString();
        assertEquals(orderString, "orange");
    }

    @Test
    public void noOrderTest() { //printout kitchen 3
        String orderString = "";
        k = new kitchen();
        tickets.add(t4);
        k.ticketsToKitchenTickets(tickets);
        LinkedList<kitchenTicket> kit = k.getKitchenTickets();
        orderString = kit.get(0).getOrderString();
        assertEquals(orderString, "");
    }

    @Test
    public void noTicketsTest() {
        k = new kitchen();
        k.ticketsToKitchenTickets(null);
        assertNull(k.getKitchenTickets());
    }

    @Test
    public void emptyTicketsTest() {
        k = new kitchen();
        k.ticketsToKitchenTickets(tickets);
        assertNull(k.getKitchenTickets());
    }

    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("kitchenTest");
	}
    
}
