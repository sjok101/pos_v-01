import java.util.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class tableJsonTest {
    table t1 = null;
    table t2 = null;
    table t3 = null;
    table t4 = null;
    LinkedList<table> tables = null;
    LinkedList<table> tablesJson = null;

    @Before
    public void setupTest() {
        t1 = new table(1, 2, "open", 1, "available");
        t2 = new table(2, 1, "full", 3, "occupied");
        t3 = new table(3, 3, "reserved", 5, "reserved for a family");
        t4 = new table(4, 5, "broken", 3, "broken table");
    }

    @Test
    public void normalMultipleTablesTest() {
        try{
            tableJson tj = new tableJson();
            tables = new LinkedList<table>();
            tablesJson = new LinkedList<table>();
            tables.add(t1);
            tables.add(t2);
            tables.add(t3);
            tables.add(t4);
            assertEquals(4,tables.size());
            tj.tablesToJson(tables); 
            tablesJson = tj.getTablesJson();
            assertEquals("available", tablesJson.get(0).description);
            assertEquals("open", tablesJson.get(0).status);
            assertEquals("occupied", tablesJson.get(1).description);
            assertEquals("full", tablesJson.get(1).status);
            assertEquals("reserved", tablesJson.get(2).description);
            assertEquals("reserved for a family", tablesJson.get(2).status);
            assertEquals("broken", tablesJson.get(3).description);
            assertEquals("broken table", tablesJson.get(3).status);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void normalSingleTableTest() {
        try{
            tableJson tj = new tableJson();
            tables = new LinkedList<table>();
            tablesJson = new LinkedList<table>();
            tables.add(t2);
            tj.tablesToJson(tables); 
            tablesJson = tj.getTablesJson();
            assertEquals("occupied", tablesJson.get(0).description);
            assertEquals("full", tablesJson.get(0).status);
        }catch(IOException e) {
            e.printStackTrace();
        } 
    }

    @Test
    public void noTableTest() {
        tables = new LinkedList<table>();
        tablesJson = new LinkedList<table>();
        tableJson tj = new tableJson();
        try{
            tj.tablesToJson(tables); 
            tablesJson = tj.getTablesJson();
        }catch(IOException e) {
            e.printStackTrace();
        }
        assertEquals(0, tablesJson.size());
    }
}
