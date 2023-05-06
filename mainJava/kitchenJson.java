
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.*;
import java.io.File;

public class kitchenJson {
    public static void main(String[]args) throws IOException{
        kitchenJson kj = new kitchenJson();
        LinkedList<Ticket> tickets = new LinkedList<Ticket>();
        Dish d1 = new Dish("apples", 0);
        Dish d2 = new Dish("orange", 0);
        Dish d3 = new Dish("banna", 0);
        Dish d4 = new Dish("pie", 0);
        Dish d5 = new Dish("steak", 0);
        Dish d6 = new Dish("steak", 0);
        Dish d7 = new Dish("apples", 0);
        Dish d8 = new Dish("orange", 0);
        //ticket 1
        Ticket t1 = new Ticket(1);
        t1.addDish(d1);
        t1.addDish(d2);
        t1.addDish(d3);
        t1.addDish(d4);
        t1.addDish(d5);
        t1.addDish(d6);
        t1.addDish(d7);
  
        //ticket 2
        Ticket t2 = new Ticket(2);
        t2.addDish(d8);
        t2.addDish(d4);
        t2.addDish(d3);
        t2.addDish(d5);
        t2.addDish(d2);
        t2.addDish(d1);
        t2.addDish(d2);
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

      public LinkedList<kitchenTicket> getKitchenTicketsJson() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<kitchenTicket> listTickets = objectMapper.readValue(new File("saves/kitchenTickets.json"), new TypeReference<List<kitchenTicket>>(){});
        LinkedList<kitchenTicket> KitchenTickets = new LinkedList<kitchenTicket>(listTickets);
        return KitchenTickets;
      }
  
      public void KitchenTicketsToJson(LinkedList<kitchenTicket> tickets) throws IOException{
        ObjectMapper activeTicketMapper = new ObjectMapper();
        activeTicketMapper.writeValue(new File("saves/kitchenTickets.json"), tickets);
      }
}
