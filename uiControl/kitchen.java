package uiControl;
import java.util.*;

import mainJava.Dish;
import mainJava.Order;

//waiting for ui functions to continue
public class kitchen {

    public LinkedList<Ticket> tickets = null;
    public LinkedList<kitchenTicket> ktickets = null;


    public kitchen() { //Constructor?
        this.tickets = new LinkedList<Ticket>();
        this.ktickets = new LinkedList<kitchenTicket>();
        
    }

    public void addTicket(Ticket t) {
        this.tickets.add(t);
    }

    public void printTickets() {
        ArrayList<String> printedTickets = new ArrayList<String>();
        String printedOrders = "";
        boolean validOrder = false;
        boolean firstIteration = true;
        for(Ticket t: tickets) {
            validOrder = false;
            printedOrders = t.getCreationTime() + ":" + t.getPriority() +":" +t.getTableNum() + ":" + t.getTicketID();
            Hashtable<Integer,LinkedList<Order>> o = t.getOrders();
            Set<Integer> orderNumSet = o.keySet();
            printedOrders +=":";
            for(int oNum: orderNumSet) {
               LinkedList<Order> orders = o.get(oNum);
               for(Order order: orders) {
                    if(order.getDishes() != null) {
                        LinkedList<Dish> d = order.getDishes();
                        for(Dish dish: d) {
                            if(dish.getName() != null) {
                                validOrder = true;
                                if(firstIteration == false) {
                                    printedOrders +=";";
                                }
                                if(dish.getDescription() != null) {
                                    printedOrders += dish.getName() + "," + dish.getDescription();
                                }
                                else {
                                    printedOrders += dish.getName();
                                }
                            }
                            firstIteration = false;
                        }
                    }
               }
            }
            if(validOrder == true) {
                printedTickets.add(printedOrders);
            }
            printedOrders = "";
            firstIteration = true;
        }  
        for(String printedTicket :printedTickets) {
            StringTokenizer tokenizer = new StringTokenizer(printedTicket, ":");
            kitchenTicket k = new kitchenTicket();
            k.setCreationTime(tokenizer.nextToken());
            k.setPriority(Integer.parseInt(tokenizer.nextToken()));
            k.settableNumber(Integer.parseInt(tokenizer.nextToken()));
            k.setTicketid(Integer.parseInt(tokenizer.nextToken()));
            k.setOrderString(tokenizer.nextToken());
            this.ktickets.add(k);
        }
    }

    public void completeTicket(int ticketID) {

        for(Ticket t: tickets) {
            if(t.getTicketID() == ticketID) {
                this.tickets.remove(t);
                break;
            }
        }
        for(kitchenTicket k: ktickets) {
            if(k.getTicketid() == ticketID) {
                this.tickets.remove(k);
                break; 
            }
        }
    }


}
