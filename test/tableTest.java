
import java.util.*;
import java.util.regex.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;



import static org.junit.Assert.*;

public class tableTest {

    private table t1 = null;
    private table t2 = null;


    @Before
    public void setupTest() { //setup all variations of tables to test each one
        t1 = new table(1,4,"open",1,"round"); // normal table
        t2 = new table(); // empty
    }


    @Test
    public void setCorrectTableNumberTest() { //checks table setting correctly   
        t1.setTableNumber(5);
        int x = 5;
        assertEquals(x, t1.getTableNumber());
    }

    @Test
    public void checksIfSettingTableNumberIsNegativeDoesntsetTest() { //checks invalid params 
        t1.setTableNumber(-5);
        int x = 1;
        assertEquals(x, t1.getTableNumber());

    }

    @Test
    public void correctNumberOfSeatedTest() { //checks seats setting correctly   
        t1.setNumberOfSeats(7);
        int x = 7;
        assertEquals(x, t1.getNumberOfSeats());
    }

    @Test
    public void atLeastOneSeatedAndNotTooManySeatedTest() {  
        t1.setNumberOfSeats(-1);
        int x = 4;
        assertEquals(x, t1.getNumberOfSeats());
        t1.setNumberOfSeats(120);
        assertEquals(x, t1.getNumberOfSeats());
    }

    @Test
    public void getCorrectTableNumberTest() {  
        int x = 1;
        assertEquals(x, t1.getTableNumber());
    }

    @Test
    public void getCorrectNumberOfSeatsTest() { 
        int x = 4;
        assertEquals(x, t1.getNumberOfSeats());
    }

    @Test
    public void checkNoTicketForTable() {  
        assertEquals(1, t1.getTicket());
    }

    @Test
    public void checksIfSettingTicketIDIsNegativeDoesntsetTest() {  
        t1.setTicket(-5);
        int x = 1;
        assertEquals(x, t1.getTicket());
    }

    @Test
    public void checksSettingTicketIDTest() {  
        t1.setTicket(2);
        int x = 2;
        assertEquals(x, t1.getTicket());
    }

    @Test
    public void checksStandardGetsAndSetsForStringsTest() { 
        String y = "open";
        String z = "round";
        String c = "square";
        assertEquals(y, t1.getStatus());
        assertEquals(z, t1.getDescription());
        t1.setTableDescription("square");
        assertEquals(c, t1.getDescription());
    }
    
    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("tableTest");
	}

}
