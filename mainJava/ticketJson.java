import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ticketJson {
    public LinkedList<Ticket> getTicketsJson() throws IOException{
        ObjectMapper ticketMapper = new ObjectMapper();
        List<jsonTicket> listTickets = ticketMapper.readValue(new File("saves/activeTickets.json"), new TypeReference<List<jsonTicket>>(){});
        LinkedList<Ticket> tickets = new LinkedList<Ticket>();
        String order = "";
        for(jsonTicket jt: listTickets) {
            Ticket t = new Ticket(0);
            t.setTableNum(Integer.parseInt(jt.getTablenum()));
            t.setTicketID(Integer.parseInt(jt.getTicketID()));
            jt.setCreationTime(t.getCreationTime());
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
}
