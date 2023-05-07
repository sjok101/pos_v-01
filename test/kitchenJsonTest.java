import java.util.*;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class kitchenJsonTest {

    LinkedList<Ticket> tickets  = null;
    LinkedList<kitchenTicket> kitchenJson = null;
    Dish d1 = null;
    Dish d2 = null;
    Dish d3 = null;
    Dish d4 = null;
    Dish d5 = null;
    Dish d6 = null;
    Dish d7 = null;
    Dish d8 = null;
    Ticket t1 = null;
    Ticket t2 = null;
    Ticket t3 = null;
    kitchen k = null;

    @Test
    public void normalMultipleKitchenTicketTest() { //test kitchen json interaction with multiple tickets types of tickets
        try{
            d1 = new Dish("apples", 0);
            d2 = new Dish("orange", 0);
            d3 = new Dish("strawberry", 0);
            d4 = new Dish("pie", 0);
            d5 = new Dish("water", 0);
            kitchenJson kj = new kitchenJson();
            tickets = new LinkedList<Ticket>();
            kitchenJson = new LinkedList<kitchenTicket>();
            k = new kitchen();
            t1 = new Ticket(1);
            t2 = new Ticket(2);
            t3 = new Ticket(3);
            t1.addDish(d1);
            t1.addDish(d2);
            t1.addDish(d3);
            t1.addDish(d5);
            tickets.add(t1);
            t2.addDish(d4);
            tickets.add(t2);
            tickets.add(t3);
            assertEquals(3,tickets.size());
            k.ticketsToKitchenTickets(tickets);
            LinkedList<kitchenTicket> kit = k.getKitchenTickets();
            assertEquals(3,kit.size());
            assertEquals("apples,orange,strawberry,water",kit.get(0).getOrderString());
            assertEquals("pie",kit.get(1).getOrderString());
            assertEquals("",kit.get(2).getOrderString());
            kj.KitchenTicketsToJson(k.getKitchenTickets());
            kitchenJson = kj.getKitchenTicketsJson();
            assertEquals(3,kitchenJson.size());
            assertEquals("apples,orange,strawberry,water",kitchenJson.get(0).getOrderString());
            assertEquals("pie",kitchenJson.get(1).getOrderString());
            assertEquals("",kitchenJson.get(2).getOrderString());
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void normalSingleKitchenTicketTest1() {  //test kitchen json interaction with 1 ticket that has multiple dishes
        try{
            kitchenJson kj = new kitchenJson();
            tickets = new LinkedList<Ticket>();
            kitchenJson = new LinkedList<kitchenTicket>();
            d6 = new Dish("steak", 0);
            d7 = new Dish("fries", 0);
            k = new kitchen();
            t1 = new Ticket(1);
            t1.addDish(d6);
            t1.addDish(d7);
            tickets.add(t1);
            assertEquals(1,tickets.size());
            k.ticketsToKitchenTickets(tickets);
            LinkedList<kitchenTicket> kit = k.getKitchenTickets();
            assertEquals(1,kit.size());
            assertEquals("steak,fries",kit.get(0).getOrderString());
            kj.KitchenTicketsToJson(k.getKitchenTickets());
            kitchenJson = kj.getKitchenTicketsJson();
            assertEquals(1,kitchenJson.size());
            assertEquals("steak,fries",kitchenJson.get(0).getOrderString());
        }catch(IOException e) {
            e.printStackTrace();
        } 
    }

    @Test
    public void normalSingleKitchenTicketTest2() { //test kitchen json interaction with 1 ticket that has 1 dish
        try{
            kitchenJson kj = new kitchenJson();
            tickets = new LinkedList<Ticket>();
            kitchenJson = new LinkedList<kitchenTicket>();
            d8 = new Dish("burger", 0);
            t1 = new Ticket(1);
            k = new kitchen();
            t1.addDish(d8);
            tickets.add(t1);
            assertEquals(1,tickets.size());
            k.ticketsToKitchenTickets(tickets);
            LinkedList<kitchenTicket> kit = k.getKitchenTickets();
            assertEquals(1,kit.size());
            assertEquals("burger",kit.get(0).getOrderString());
            kj.KitchenTicketsToJson(k.getKitchenTickets());
            kitchenJson = kj.getKitchenTicketsJson();
            assertEquals(1,kitchenJson.size());
            assertEquals("burger",kitchenJson.get(0).getOrderString());
        }catch(IOException e) {
            e.printStackTrace();
        } 
    }

    @Test
    public void nokitchenTicketsTest() { //test kitchen json interaction with no tickets
        try{
            kitchenJson kj = new kitchenJson();
            tickets = new LinkedList<Ticket>();
            kitchenJson = new LinkedList<kitchenTicket>();
            t1 = new Ticket(1);
            k = new kitchen();
            assertEquals(0,tickets.size());
            k.ticketsToKitchenTickets(tickets);
            LinkedList<kitchenTicket> kit = k.getKitchenTickets();
            assertNull(kit);
            kj.KitchenTicketsToJson(k.getKitchenTickets());
            kitchenJson = kj.getKitchenTicketsJson();
            assertEquals(0,kitchenJson.size());
        }catch(IOException e) {
            e.printStackTrace();
        } 
    }

    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("kitchenJsonTest");
	}
}
