import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ticketJson {
    public static void main(String[]args) throws IOException{
        Dish d2 = new Dish("orange", 0);
        Dish d3 = new Dish("banna", 0);
        LinkedList<Dish> d = new LinkedList<Dish>();
        d.add(d2);
        d.add(d3);
        Ticket t1 = new Ticket(1, d);
        LinkedList<Ticket> tickets = new LinkedList<Ticket>();
        LinkedList<Ticket> ticketsJson = new LinkedList<Ticket>();
        ticketJson tj = new ticketJson();
        tickets.add(t1);
        tj.doneTicketsToJson(tickets);
        ticketsJson = tj.getDoneTicketsJson();
        System.out.println(ticketsJson.get(0).getCreationTime() + "    " + ticketsJson.get(0).getTicketID());
       

  }

    public LinkedList<Ticket> getTicketsJson() throws IOException{
        ObjectMapper ticketMapper = new ObjectMapper();
        List<jsonTicket> listTickets = ticketMapper.readValue(new File("saves/activeTickets.json"), new TypeReference<List<jsonTicket>>(){});
        LinkedList<Ticket> tickets = new LinkedList<Ticket>();
        String order = "";
        for(jsonTicket jt: listTickets) {
            Ticket t = new Ticket(1);
            t.setTableNum(Integer.parseInt(jt.getTableNum()));
            t.setTicketID(Integer.parseInt(jt.getTicketID()));
            t.setCreationTime(jt.getCreationTime());
            order = jt.getOrders();
            StringTokenizer st = new StringTokenizer(order, ",");
            while(st.hasMoreTokens()) {
                String dish = st.nextToken();
                String di[] = dish.split(":",2);
                Double p = Double.parseDouble(di[1]);
                Dish d = new Dish(di[0], p);
                t.addDish(d);
            }
            t.setPriority(Integer.parseInt(jt.getPriority()));
            tickets.add(t);
        }
        return tickets;
      }
  
      public void ticketsToJson(LinkedList<Ticket> tickets) throws IOException{
        ObjectMapper ticketMapper = new ObjectMapper();
        LinkedList<jsonTicket> jsontickets = new LinkedList<jsonTicket>();
        String order = "";
        for(Ticket t: tickets) {
            jsonTicket jt = new jsonTicket();
            jt.setTableNum(String.valueOf(t.getTableNum()));
            jt.setTicketID(String.valueOf(t.getTicketID()));
            jt.setCreationTime(String.valueOf(t.getCreationTime()));
            LinkedList<Dish> dishs = t.getOrders();
            int counter = dishs.size();
            for(Dish d: dishs) {
                order += d.name + ":";
                order += d.price;
                counter--;
                if(counter != 0) {
                    order +=",";  
                }
            }
            jt.setOrders(order);
            jt.setTotal(String.valueOf(t.getTotal()));
            jt.setTogo(String.valueOf(t.getTogo()));
            jt.setPriority(String.valueOf(t.getPriority()));
            jsontickets.add(jt);
            order = "";
        }
        ticketMapper.writeValue(new File("saves/activeTickets.json"), jsontickets);
      }

      public LinkedList<Ticket> getDoneTicketsJson() throws IOException{
        ObjectMapper ticketMapper = new ObjectMapper();
        List<jsonTicket> listTickets = ticketMapper.readValue(new File("saves/oldTickets.json"), new TypeReference<List<jsonTicket>>(){});
        LinkedList<Ticket> tickets = new LinkedList<Ticket>();
        String order = "";
        for(jsonTicket jt: listTickets) {
            Ticket t = new Ticket(1);
            t.setTableNum(Integer.parseInt(jt.getTableNum()));
            t.setTicketID(Integer.parseInt(jt.getTicketID()));
            t.setCreationTime(jt.getCreationTime());
            t.setClosingTime(jt.getClosingTime());
            order = jt.getOrders();
            StringTokenizer st = new StringTokenizer(order, ",");
            while(st.hasMoreTokens()) {
                String dish = st.nextToken();
                String di[] = dish.split(":",2);
                Double p = Double.parseDouble(di[1]);
                Dish d = new Dish(di[0], p);
                t.addDish(d);
            }
            t.setPriority(Integer.parseInt(jt.getPriority()));
            tickets.add(t);
        }
        return tickets;
      }
  
      public void doneTicketsToJson(LinkedList<Ticket> tickets) throws IOException{
        ObjectMapper ticketMapper = new ObjectMapper();
        LinkedList<jsonTicket> jsontickets = new LinkedList<jsonTicket>();
        String order = "";
        for(Ticket t: tickets) {
            jsonTicket jt = new jsonTicket();
            jt.setTableNum(String.valueOf(t.getTableNum()));
            jt.setTicketID(String.valueOf(t.getTicketID()));
            jt.setCreationTime(String.valueOf(t.getCreationTime()));
            jt.setClosingTime(t.getClosingTime());
            LinkedList<Dish> dishs = t.getOrders();
            int counter = dishs.size();
            for(Dish d: dishs) {
                order += d.name + ":";
                order += d.price;
                counter--;
                if(counter != 0) {
                    order +=",";  
                }
            }
            jt.setOrders(order);
            jt.setTotal(String.valueOf(t.getTotal()));
            jt.setTogo(String.valueOf(t.getTogo()));
            jt.setPriority(String.valueOf(t.getPriority()));
            jsontickets.add(jt);
            order = "";
        }
        ticketMapper.writeValue(new File("saves/oldTickets.json"), jsontickets);
      }
}
