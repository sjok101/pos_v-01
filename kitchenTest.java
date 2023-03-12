
import java.util.*;
import java.util.regex.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;
import static org.junit.Assert.*;

public class kitchenTest {
    kitchen k1 = null; //> 1 order in kitchen
    kitchen k2 = null; // 1 order in kitchen
    kitchen k3 = null; //< 1 order in kitchen

    @Before
    public void setupTest() {
        
        k1 = new kitchen(); //> 1 ticket in kitchen
        k2 = new kitchen(); // 1 ticket in kitchen
        k3 = new kitchen(); //< 1 ticket in kitchen
        //make tickets here
        ticket t = null;
        k1.tickets.add(t);
        k2.tickets.add(t);
        //add random other tickets to k1 here
        k1.tickets.add(t);
        k1.tickets.add(t);
        k1.tickets.add(t);
        k1.tickets.add(t);
        k1.tickets.add(t);
    }

    @Test
    public void printOrderTest1() { //print out orders 1
        //gets printed out order string and compares it to expected printout
        String orderString = "";
        orderString = k1.printOrders();
        assertEquals(orderString, "");
    }

    @Test
    public void printOrderTest2() { //printout kitchen 2
        String orderString = "";
        orderString = k2.printOrders();
        assertEquals(orderString, "");
    }

    @Test
    public void printOrderTest3() { //printout kitchen 3
        String orderString = "";
        orderString = k3.printOrders();
        assertEquals(orderString, "");
    }

    @Test
    public void completeTicketTest1() { //test kitchen 1 completing edge orders
        String orderString = "";
        boolean complete = false;
        Ticket t = null;
        //do stuff
        complete = k1.completeTicket(t);
        orderString = k1.printOrders();
        assertEquals(orderString, "");
        assertTrue(complete);

        complete = k1.completeTicket(t);
        orderString = k1.printOrders();
        assertEquals(orderString, "");
        assertTrue(complete);
    }

    @Test
    public void completeTicketTest2() { //test  kitchen 1 completing middle orders and out of bounds
        String orderString = "";
        boolean complete = false;
        //do stuff
        Ticket t = null;
        complete = k1.completeTicket(t);
        orderString = k1.printOrders();
        assertEquals(orderString, "");
        assertTrue(complete);

        complete = k1.completeTicket(t);
        orderString = k1.printOrders();
        assertEquals(orderString, "");
        assertFalse(complete);
    }

    @Test
    public void completeTicketTest3() { //test kitchen 2 completing
        String orderString = "";
        boolean complete = false;
        Ticket t = null;
        //do stuff
        complete = k2.completeTicket(t);
        orderString = k2.printOrders();
        assertEquals(orderString, "");
        assertTrue(complete);
    }

    @Test
    public void completeTicketTest4() { //test  kitchen 2 completing no orders and out of bounds
        String orderString = "";
        boolean complete = false;
        Ticket t = null;
        //do stuff
        complete = k2.completeTicket(t);
        orderString = k2.printOrders();
        assertEquals(orderString, "");
        assertFalse(complete);
    }

    @Test
    public void completeTicketTest5() { //failing/passing orders 3 because it empty
        String orderString = "";
        boolean complete = false;
        Ticket t = null;
        //do stuff
        complete = k3.completeTicket(t);
        orderString = k3.printOrders();
        assertEquals(orderString, "");
        assertFalse(complete);
    }

    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("kitchenTest");
	}
    
}
