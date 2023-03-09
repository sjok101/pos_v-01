
import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TicketTest {
    
    private Ticket tik1 = null;
    private Ticket tik2 = null;
    private Hashtable<Integer, LinkedList<Order>> ticket_orders1 = null;

    //normal constructor just tablenum
    @Test 
    public void ticketConstuctorTest1(){
        tik1 = new Ticket(5);
    }

    //constructor with tablenum and one order
    @Test 
    public void ticketConstuctorTest2(){
        Order o1 = new Order(2);
        LinkedList<Order> seat1orders = new LinkedList<>();
        seat1orders.add(o1);
        ticket_orders1.put(1, seat1orders);
        tik1 = new Ticket(2,ticket_orders1);
    }

    //normal constructor with tablenum and many orders
    @Test 
    public void ticketConstuctorTest3(){
        Order o1 = new Order(2);
        Order o2 = new Order(2);
        Order o3 = new Order(2);
        LinkedList<Order> seat1orders = new LinkedList<>();
        seat1orders.add(o1);
        seat1orders.add(o2);
        seat1orders.add(o3);
        ticket_orders1.put(1, seat1orders);
        tik1 = new Ticket(2,ticket_orders1);
    }

    //normal constructor with tablenum and null orders
    @Test (expected = NullPointerException.class)
    public void ticketConstuctorTest4(){
        tik1 = new Ticket(2,null);
    }

    //normal constructor with negative tablenum
    @Test (expected = IndexOutOfBoundsException.class)
    public void ticketConstuctorTest5(){
        tik1 = new Ticket(-2);
    }

    @Before
    public void setupTest(){
        tik1 = new Ticket(1);
        tik2 = new Ticket(10);
    }

    //normal value
    @Test
    public void setTableNum1(){
        Ticket t = new Ticket(3);
        t.setTableNum(1);
        assertEquals(t.getTableNum(), 1);

    }

    //larger value
    @Test
    public void setTableNum2(){
        Ticket t = new Ticket(3);
        t.setTableNum(10);
        assertEquals(t.getTableNum(), 10);

    }

    //negative value
    @Test (expected = IndexOutOfBoundsException.class)
    public void setTableNum3(){
        Ticket t = new Ticket(1);
        t.setTableNum(-10);

    }

    //table number 0
    @Test (expected = IndexOutOfBoundsException.class)
    public void setTableNum4(){
        Ticket t = new Ticket(2);
        t.setTableNum(0);
    }

    //normal ticketID
    @Test 
    public void setTicketID1(){
        Ticket t = new Ticket(2);
        t.setTicketID(5);
        assertEquals(t.getTicketID(), 5);
    }

    //large ticketID
    @Test 
    public void setTicketID2(){
        Ticket t = new Ticket(10);
        t.setTicketID(250);
        assertEquals(t.getTicketID(), 250);
    }

    //negative ticketID
    @Test (expected = IndexOutOfBoundsException.class)
    public void setTicketID3(){
        Ticket t = new Ticket(10);
        t.setTicketID(-2);
    }

    //0 ticketID
    @Test (expected = IndexOutOfBoundsException.class)
    public void setTicketID4(){
        Ticket t = new Ticket(10);
        t.setTicketID(0);
    }

    //normal total
    @Test 
    public void setTicketTotal1(){
        Ticket t = new Ticket(10);
        t.setTotal(10.25);
        assertEquals(t.getTotal(),10.25, 0);
    }

    //normal total rounded
    @Test 
    public void setTicketTotal2(){
        Ticket t = new Ticket(10);
        t.setTotal(10.251);
        assertEquals(t.getTotal(),10.25, 0);
    }

    //negative total
    @Test (expected = IndexOutOfBoundsException.class)
    public void setTicketTotal3(){
        Ticket t = new Ticket(10);
        t.setTotal(-10);
    }

    //negative decimal total
    @Test (expected = IndexOutOfBoundsException.class)
    public void setTicketTotal4(){
        Ticket t = new Ticket(10);
        t.setTotal(-10.50);
    }

    //zero total
    @Test 
    public void setTicketTotal5(){
        Ticket t = new Ticket(10);
        t.setTotal(0);
        assertEquals(t.getTotal(),0.0, 0);
    }

    public static void main(String args[]){
        org.junit.runner.JUnitCore.main("TicketTest");
    }
    

}
