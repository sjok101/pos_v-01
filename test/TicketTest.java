import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;


public class TicketTest {
    private Ticket tik1 = null;
    private LinkedList<Dish> dishes1 = new LinkedList<Dish>();
    private Dish d1 = new Dish("Green Beans",  0);
    private Dish d2 = new Dish("mashed potatoes",15);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private LocalDateTime now = LocalDateTime.now();
    private String timenow = dtf.format(now);

    @Before
    public void setupTest(){
        tik1 = new Ticket(1);
        d1.setPrice(25.25);
        d1.setDescription("Some tasty green beans");
        d2.setPrice(50.25);
        d2.setDescription("Some tasty potatoes");
        dishes1.add(d1);
        dishes1.add(d2);
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
        Dish d1 = new Dish("beans", 1);

        LinkedList<Dish> orders = new LinkedList<>();
        orders.add(d1);
        tik1 = new Ticket(2, orders);
        if(tik1.getTableNum() == 2){
            assertEquals(tik1.getDishes(), orders);
        }
    }

    //normal constructor with tablenum and many orders
    @Test 
    public void ticketConstuctorTest4(){
        Dish d1 = new Dish("beans", 1);
        Dish d2 = new Dish("fires", 2);
        Dish d3 = new Dish("soda", 3);
        LinkedList<Dish> orders = new LinkedList<>();
        orders.add(d1);
        orders.add(d2);
        orders.add(d3);
        tik1 = new Ticket(5,orders);
        if(tik1.getTableNum() == 5){
            assertEquals(tik1.getDishes(), orders);
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
        t.addDish(d1);
        assertEquals(25.25, t.getTotal(), 0);
    }

    //order with one dish inside
    @Test 
    public void addOrder3(){
        Ticket t = new Ticket(10);
        t.addDish(d1);
        t.addDish(d2);
        assertEquals(75.50, t.getTotal(), 0);
    }

    //remove one order
    @Test 
    public void removeOrder1(){
        Ticket t = new Ticket(10);
        t.addDish(d1);
        t.addDish(d2);
        t.removeDish(d1);
        assertEquals(50.25, t.getTotal(), 0);
    }

    //remove other order
    @Test 
    public void removeOrder2(){
        Ticket t = new Ticket(10);
        t.addDish(d1);
        t.addDish(d2);
        t.removeDish(d2);
        assertEquals(25.25, t.getTotal(), 0);
    }

     //remove last order
     @Test 
     public void removeOrder3(){
        Ticket t = new Ticket(10);
        t.addDish(d1);
        t.removeDish(d1);
        assertEquals(0.0, t.getTotal(), 0);
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