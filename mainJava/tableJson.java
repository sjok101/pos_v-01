

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.io.File;

class tableJson {
    public static void main(String[]args) throws IOException{
          table t1 = new table(1, 2, "open", 1, "agggf");
          table t2 = new table(2, 1, "full", 3, "afafff");
          table t3 = new table(3, 3, "yo", 5, "afaf");
          LinkedList<table> tables = new LinkedList<table>();
          LinkedList<table> tablesJson = new LinkedList<table>();
          tableJson tj = new tableJson();
          tables.add(t1);
          tables.add(t2);
          tables.add(t3);
          tj.tablesToJson(tables);
          tablesJson = tj.getTablesJson();
          
          System.out.println(tablesJson.get(1).description);
          System.out.println(tablesJson.get(0).description);
          System.out.println(tablesJson.get(2).description);

    }

    public LinkedList<table> getTablesJson() throws IOException{
      ObjectMapper objectMapper = new ObjectMapper();
      List<table> listtables = objectMapper.readValue(new File("saves/tables.json"), new TypeReference<List<table>>(){});
      LinkedList<table> tables = new LinkedList<table>(listtables);
      return tables;
    }

    public void tablesToJson(LinkedList<table> tables) throws IOException{
      ObjectMapper tableMapper = new ObjectMapper();
      tableMapper.writeValue(new File("saves/tables.json"), tables);
    }
    
}