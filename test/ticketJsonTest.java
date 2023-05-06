import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import org.junit.*;

public class ticketJsonTest {
    private Ticket t1;
    private Ticket t2;
    private Ticket t3;
    private Ticket t4;
    private Dish d1;
    private Dish d2;
    private Dish d3;
    private Dish d4;
    private LinkedList<Ticket> tickets;
    private LinkedList<Ticket> ticketsJSON;
    private LinkedList<jsonTicket> JSONs;

    @Before
    public void setupTest(){
        t1 = new Ticket(1);
        t2 = new Ticket(2);
        t3 = new Ticket(3);
        t4 = new Ticket(4);
        d1 = new Dish("potato", 5.0, 1);
        d2 = new Dish("bean", 1.20, 2);
        d3 = new Dish("rice", 0.5, 3);
        d4 = new Dish("ice", 0.0,4);

    }

    @Test
    public void testGetTickets(){
        try{
            ticketJson tj = new ticketJson();
            tickets = new LinkedList<Ticket>();
            ticketsJSON = new LinkedList<Ticket>();
            t1.addDish(d1);
            t1.addDish(d2);
            t2.addDish(d3);
            t2.addDish(d4);
            t1.setPriority(2);
            t2.setPriority(1);
            t1.setTicketID(4);
            t2.setTicketID(69);
            t1.setClosingTime("13");
            t2.setClosingTime("10:49");
            tickets.add(t1);
            tickets.add(t2);
            assertEquals(2,tickets.size());
            tj.ticketsToJson(tickets); 
            ticketsJSON = tj.getTicketsJson();
            assertEquals(2, ticketsJSON.get(0).getPriority());
            assertEquals(1, ticketsJSON.get(1).getPriority());
            assertEquals(4, ticketsJSON.get(0).getTicketID());
            assertEquals(69, ticketsJSON.get(1).getTicketID());
            assertEquals("13", ticketsJSON.get(0).getClosingTime());
            assertEquals("10:49", ticketsJSON.get(1).getClosingTime());
            assertEquals(6.20, ticketsJSON.get(3).getTotal(), 0);
            assertEquals(0.5, ticketsJSON.get(3).getTotal(), 0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDoneTickets(){
        try{
            ticketJson tj = new ticketJson();
            tickets = new LinkedList<Ticket>();
            ticketsJSON = new LinkedList<Ticket>();
            t1.addDish(d1);
            t1.addDish(d2);
            t2.addDish(d3);
            t2.addDish(d4);
            t1.setPriority(2);
            t2.setPriority(1);
            t1.setTicketID(4);
            t2.setTicketID(69);
            t1.setClosingTime("13");
            t2.setClosingTime("10:49");
            tickets.add(t1);
            tickets.add(t2);
            assertEquals(2,tickets.size());
            tj.doneTicketsToJson(tickets); 
            ticketsJSON = tj.getDoneTicketsJson();
            assertEquals(2, ticketsJSON.get(0).getPriority());
            assertEquals(1, ticketsJSON.get(1).getPriority());
            assertEquals(4, ticketsJSON.get(0).getTicketID());
            assertEquals(69, ticketsJSON.get(1).getTicketID());
            assertEquals("13", ticketsJSON.get(0).getClosingTime());
            assertEquals("10:49", ticketsJSON.get(1).getClosingTime());
            assertEquals(6.20, ticketsJSON.get(3).getTotal(), 0);
            assertEquals(0.5, ticketsJSON.get(3).getTotal(), 0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetTicketsHistory(){
        try{
            ticketJson tj = new ticketJson();
            JSONs = tj.getTicketsHistory();
            assertEquals("2", JSONs.get(0).getPriority());
            assertEquals("1", JSONs.get(1).getPriority());
            assertEquals("4", JSONs.get(0).getTicketID());
            assertEquals("69", JSONs.get(1).getTicketID());
            assertEquals("13", JSONs.get(0).getClosingTime());
            assertEquals("10:49", JSONs.get(1).getClosingTime());
            assertEquals("6.20", JSONs.get(3).getTotal());
            assertEquals("0.5", JSONs.get(3).getTotal());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
