
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.*;
import java.io.File;

public class kitchenJson {
    public static void main(String[]args) throws IOException{
        kitchenJson kj = new kitchenJson();
        LinkedList<Ticket> tickets = new LinkedList<Ticket>();
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
        Ticket t1 = new Ticket(1);
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
        Ticket t2 = new Ticket(2);
        o5.addDish(d8);
        o5.addDish(d4);
        t2.addOrder(o5);
        o6.addDish(d3);
        t2.addOrder(o6);
        o7.addDish(d5);
        o7.addDish(d2);
        t2.addOrder(o7);
        o8.addDish(d1);
        o8.addDish(d2);
        t2.addOrder(o8);
        LinkedList<kitchenTicket> kitchenJson = new LinkedList<kitchenTicket>();
        kitchen k = new kitchen();
        tickets.add(t1);
        tickets.add(t2);
        k.ticketsToKitchenTickets(tickets);
        LinkedList<kitchenTicket> kit = k.getKitchenTickets();
        for(int i = 0; kit.size() > i; i++) {
            System.out.println(kit.get(i).getOrderString());
        }
        kj.KitchenTicketsToJson(k.getKitchenTickets());
        kitchenJson = kj.getKitchenTicketsJson();
        if(kitchenJson.size() > 0) {
            System.out.println(kitchenJson.get(0).getOrderString());
            System.out.println(kitchenJson.get(1).getOrderString());
        }
        else {
            System.out.println("something wrong");
        }

  }
    public LinkedList<Ticket> getActiveTicketsJson() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ticket> listTickets = objectMapper.readValue(new File("mainJava/activeTickets.json"), new TypeReference<List<Ticket>>(){});
        LinkedList<Ticket> activeTickets = new LinkedList<Ticket>(listTickets);
        return activeTickets;
      }
  
      public void activeTicketsToJson(LinkedList<Ticket> tickets) throws IOException{
        ObjectMapper activeTicketMapper = new ObjectMapper();
        activeTicketMapper.writeValue(new File("mainJava/activeTickets.json"), tickets);
      }

      public LinkedList<kitchenTicket> getKitchenTicketsJson() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<kitchenTicket> listTickets = objectMapper.readValue(new File("mainJava/kitchenTickets.json"), new TypeReference<List<kitchenTicket>>(){});
        LinkedList<kitchenTicket> KitchenTickets = new LinkedList<kitchenTicket>(listTickets);
        return KitchenTickets;
      }
  
      public void KitchenTicketsToJson(LinkedList<kitchenTicket> tickets) throws IOException{
        ObjectMapper activeTicketMapper = new ObjectMapper();
        activeTicketMapper.writeValue(new File("mainJava/kitchenTickets.json"), tickets);
      }
}
