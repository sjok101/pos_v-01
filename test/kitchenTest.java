

import java.util.*;
import java.util.regex.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;



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
        Order o1 = new Order(1);
        Order o2 = new Order(1);
        Order o3 = new Order(1);
        Order o4 = new Order(1);
        Order o5 = new Order(2);
        Order o6 = new Order(2);
        Order o7 = new Order(2);
        Order o8 = new Order(2);
        Dish d1 = new Dish("apples", "", 0);
        Dish d2 = new Dish("orange", "", 0);
        Dish d3 = new Dish("banna", "", 0);
        Dish d4 = new Dish("pie", "cherry", 0);
        Dish d5 = new Dish("steak", "medium", 0);
        Dish d6 = new Dish("steak", "well done", 0);
        Dish d7 = new Dish("apples", "", 0);
        Dish d8 = new Dish("orange", "", 0);
        //ticket 1
        t1 = new Ticket(1);
        o1.addDish(d1);
        o1.addDish(d2);
        t1.addOrder(o1);
        o2.addDish(d3);
        t1.addOrder(o2);
        o3.addDish(d4);
        o3.addDish(d5);
        t1.addOrder(o3);
  
        o4.addDish(d6);
        o4.addDish(d7);
        t1.addOrder(o4); 
  
        //ticket 2
        t2 = new Ticket(2);
        o5.addDish(d8);
        o5.addDish(d4);
        t2.addOrder(o5);
        o6.addDish(d3);
        t2.addOrder( o6);
        o7.addDish(d5);
        o7.addDish(d2);
        t2.addOrder(o7);
        o8.addDish(d1);
        o8.addDish(d2);
        t2.addOrder(o8);
        //ticket 3
        t3 = new Ticket(4);
        t3.addOrder(o8);
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
                assertEquals(orderString, "apples;orange;banna;pie,cherry;steak,medium;steak,well done;apples");
            }
            else if(i == 1) {
                orderString = kit.get(i).getOrderString();
                assertEquals(orderString, "orange;pie,cherry;banna;steak,medium;orange;apples;orange");
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
        assertEquals(orderString, "apples;orange");
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
