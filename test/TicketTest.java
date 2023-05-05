import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;


public class TicketTest {
    
    private Ticket tik1 = null;
    private Ticket tik2 = null;
    private LinkedList<Order> ordrs1 = new LinkedList<>();
    private Order o1 = null;
    private Order o2 = null;
    private Hashtable<Integer, LinkedList<Order>> ticket_orders1 = new Hashtable<>();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private LocalDateTime now = LocalDateTime.now();
    private String timenow = dtf.format(now);

    @Before
    public void setupTest(){
        tik1 = new Ticket(1);
        tik2 = new Ticket(10);
        o1 = new Order(1);
        o1.setOrderID(11);
        o2 = new Order(1);
        o2.setOrderID(12);
        //Dish d1 = new Dish("Green Beans", 10);
        Dish d1 = new Dish(0, "Green Beans", "test", 0);
        d1.setPrice(25.25);
        d1.setDescription("Some tasty green beans");
        //Dish d2 = new Dish("mashed potatoes", 15);
        Dish d2 = new Dish("mashed potatoes", "test",15);
        d2.setPrice(50.25);
        d2.setDescription("Some tasty potatoes");
        o1.addDish(d1);
        o2.addDish(d2);
        ordrs1.add(o1);
    }

    //normal constructor normal tablenum
    @Test 
    public void ticketConstuctorTest1(){
        Ticket t1 = new Ticket(5);
        now = LocalDateTime.now();
        timenow = dtf.format(now);
        if(t1.getCreationTime().equals(timenow)){
            assertEquals(t1.getTableNum(), 5);
            return;
        }
        fail();
    }

    //constructor with 0 tablenum
    @Test (expected = IndexOutOfBoundsException.class)
    public void ticketConstuctorTest2(){
        tik1 = new Ticket(0);
    }

    //normal constructor with tablenum and one order
    @Test 
    public void ticketConstuctorTest3(){
        Order o1 = new Order(2);

        LinkedList<Order> seat1orders = new LinkedList<>();
        Hashtable<Integer, LinkedList<Order>> ht1 = new Hashtable<>();
        seat1orders.add(o1);
        ticket_orders1.put(1, seat1orders);
        ht1.put(1, seat1orders);
        tik1 = new Ticket(2,ht1);
        if(tik1.getTableNum() == 2){
            assertEquals(tik1.getOrders(), ht1);
        }
    }

    //normal constructor with tablenum and many orders
    @Test 
    public void ticketConstuctorTest4(){
        Order o1 = new Order(2);
        Order o2 = new Order(2);
        Order o3 = new Order(2);
        LinkedList<Order> seat1orders = new LinkedList<>();
        Hashtable<Integer, LinkedList<Order>> ht1 = new Hashtable<>();
        seat1orders.add(o1);
        seat1orders.add(o2);
        seat1orders.add(o3);
        ticket_orders1.put(1, seat1orders);
        ht1.put(1, seat1orders);
        tik1 = new Ticket(5,ht1);
        if(tik1.getTableNum() == 5){
            assertEquals(tik1.getOrders(), ht1);
        }
    }

    //normal constructor with tablenum and null orders
    @Test (expected = NullPointerException.class)
    public void ticketConstuctorTest5(){
        tik1 = new Ticket(2,null);
    }

    //normal constructor with negative tablenum
    @Test (expected = IndexOutOfBoundsException.class)
    public void ticketConstuctorTest6(){
        tik1 = new Ticket(-2);
    }

    //set/get TableNum---------------------------------
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
    //--------------------------------------------------

    //get/set ticketID----------------------------------
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
    @Test
    public void setTicketID4(){
        Ticket t = new Ticket(10);
        t.setTicketID(0);
        assertEquals(t.getTicketID(), 0);
    }
    //--------------------------------------------------

    //get/set ticketTotal-------------------------------
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
    //--------------------------------------------------

    //set/getpriority-----------------------------------
    //set priority normal number
    @Test 
    public void setTicketPriority1(){
        Ticket t = new Ticket(10);
        t.setPriority(2);
        assertEquals(t.getPriority(), 2);
    }

    //set priority to 0
    @Test 
    public void setTicketPriority2(){
        Ticket t = new Ticket(10);
        t.setPriority(0);
        assertEquals(t.getPriority(), 0);
    }

    //set priority to negative number
    @Test 
    public void setTicketPriority3(){
        Ticket t = new Ticket(10);
        t.setPriority(-10);
        assertEquals(t.getPriority(), -10);
    }
    //--------------------------------------------------

    //set/get TicketStatus------------------------------
    //set status to OPEN
    @Test 
    public void setTicketStatus1(){
        Ticket t = new Ticket(10);
        t.setStatus(Ticketstatus.OPEN);
        assertEquals(t.getStatus(), Ticketstatus.OPEN);
    }

    //set status to CLOSED
    @Test 
    public void setTicketStatus2(){
        Ticket t = new Ticket(10);
        t.setStatus(Ticketstatus.CLOSED);
        assertEquals(t.getStatus(), Ticketstatus.CLOSED);
    }
    //--------------------------------------------------

    //order with nothing inside
    @Test 
    public void addOrder1(){
        Ticket t = new Ticket(10);
        assertEquals(t.getTotal(),0.0, 0);
    }

    //order with one dish inside
    @Test 
    public void addOrder2(){
        Ticket t = new Ticket(10);
        t.addOrder(1, o1);
        assertEquals(t.getTotal(),25.25, 0);
    }

    //order with one dish inside
    @Test 
    public void addOrder3(){
        Ticket t = new Ticket(10);
        t.addOrder(1, o1);
        t.addOrder(2, o2);
        assertEquals(t.getTotal(),75.50, 0);
    }

    //remove one order
    @Test 
    public void removeOrder1(){
        Ticket t = new Ticket(10);
        t.addOrder(1, o1);
        t.addOrder(2, o2);
        t.removeOrder(1, o1);
        assertEquals(t.getTotal(),50.25, 0);
    }

    //remove other order
    @Test 
    public void removeOrder2(){
        Ticket t = new Ticket(10);
        t.addOrder(1, o1);
        t.addOrder(2, o2);
        t.removeOrder(1, o1);
        assertEquals(t.getTotal(),50.25, 0);
    }

     //remove last order
     @Test 
     public void removeOrder3(){
         Ticket t = new Ticket(10);
         t.addOrder(1, o1);
         t.removeOrder(1, o1);
         assertEquals(t.getTotal(),0.0, 0);
     }

     //test closing time
     @Test 
     public void closeTicket(){
         Ticket t = new Ticket(10);
         t.closeTicket();
         now = LocalDateTime.now();
        timenow = dtf.format(now);
        if(t.getClosingTime().equals(timenow)){
            assertEquals(t.getTableNum(), 10);
            return;
        }
        fail();
     }


    public static void main(String args[]){
        org.junit.runner.JUnitCore.main("TicketTest");
    }
    

}