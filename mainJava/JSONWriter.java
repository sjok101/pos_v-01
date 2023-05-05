import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONWriter {


    public static void main(String[]args) throws IOException{
        // table t1 = new table(1, 2, "open", 1, "agggf");
        // table t2 = new table(2, 1, "full", 3, "afafff");
        // table t3 = new table(3, 3, "yo", 5, "afaf");
        LinkedList<Order> tables = new LinkedList<Order>();
        LinkedList<Order> tablesJson = new LinkedList<Order>();
        // tables.add(t1);
        // tables.add(t2);
        // tables.add(t3);
        ticketsToJson(tables);
        tablesJson = getTicketsJson();

        // System.out.println(tablesJson.get(1).orderID);
        // System.out.println(tablesJson.get(0).description);
        // System.out.println(tablesJson.get(2).description);

  }

  public static LinkedList<Order> getTicketsJson() throws IOException{
    ObjectMapper objectMapper = new ObjectMapper();
    List<Order> listorders = objectMapper.readValue(new File("ordres.json"), new TypeReference<List<Order>>(){});
    LinkedList<Order> orders = new LinkedList<Order>(listorders);
    return orders;
  }

  public static void ticketsToJson(LinkedList<Order> tables) throws IOException{
    ObjectMapper tableMapper = new ObjectMapper();
    //tableMapper.writeValue(new File("mainJava/test.json"), Order);
  }


}
