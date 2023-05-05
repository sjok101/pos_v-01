import java.util.*;
import java.util.regex.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;

import mainJava.Ticket;
import mainJava.table;

import static org.junit.Assert.*;

public class tableTest {

    private table t1 = null;
    private table t2 = null;


    @Before
    public void setupTest() { //setup all variations of tables to test each one
        t1 = new table(1,6); // normal table
        t2 = new table(2,1); // 1 seat table
        Ticket t = new Ticket(2);
        t2.setTicket(t);
    }


    @Test
    public void setCorrectTableNumberTest() { //checks table setting correctly   
        t1.setTableNumber(5);
        int x = 5;
        assertEquals(x, t1.tableNumber);
    }

    @Test
    public void checksIfSettingTableNumberIsNegativeTest() { //checks invalid params 
        t1.setTableNumber(-5);
        int x = 1;
        assertEquals(x, t1.tableNumber);

    }

    @Test
    public void correctNumberOfSeatedTest() { //checks seats setting correctly   
        t1.setNumberOfSeats(7);
        int x = 7;
        assertEquals(x, t1.numberOfSeats);
    }

    @Test
    public void atLeastOneSeatedAndNotTooManySeatedTest() { //checks invalid param  
        t1.setNumberOfSeats(-1);
        int x = 6;
        assertEquals(x, t1.numberOfSeats);
        t1.setNumberOfSeats(56);
        assertEquals(x, t1.numberOfSeats);
    }

    @Test
    public void tableHasRightTicketTest() { //checks ticket set correctly
        Ticket t = new Ticket(1);
        t1.setTicket(t);
        assertEquals(t, t1.tableTicket);
    }

    @Test
    public void checkForBadTicketVariablesBeforeSettingTicket() { //checks bad ticket param  
        Ticket t = new Ticket(4);
        t1.setTicket(t);
        assertEquals(null, t1.tableTicket);
    }

    @Test
    public void getCorrectTableNumberTest() { //gets correct table#  
        int x = 1;
        assertEquals(x, t1.getTableNumber());
    }

    @Test
    public void getCorrectNumberOfSeatsTest() { //  gets correct number of seats 
        int x = 6;
        assertEquals(x, t1.getNumberOfSeats());
    }

    @Test
    public void getCorrectTicketTest1() {   //get ticket
        Ticket t = new Ticket(1);
        t1.setTicket(t);
        assertEquals(t1.tableTicket, t1.getTicket());
    }

    @Test
    public void checkNoTicketForTable() {   //get error if no ticket  
        assertEquals(null, t1.getTicket());
    }
    
    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("tableTest");
	}

}
