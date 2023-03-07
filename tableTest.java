import java.util.*;
import java.util.regex.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;
import static org.junit.Assert.*;

public class tableTest {

    private table t1 = null;
    private table t2 = null;
    private table t3 = null;


    @Before
    public void setupTest() { //setup all variations of tables to test each one
        t1 = new table(1,6); // normal table
        t2 = new table(2,1); // 1 seat table
    }

    
    @Test
    public void makeTicketTest1() { //make ticket for table to empty table
        ticket t = new ticket();
        //do ticket stuff
        t1.makeTicket();
        assertEquals(t1.getTicket(), t);
    }

    @Test
    public void makeTicketTest2() { //make ticket for table to full table
        String message = "";
        ticket t = new ticket();
        //ticket stuff
        t2.setTicket(t);
        t2.makeTicket(); //get error message
        assertEquals(message, " "); //check message equals
    }

    @Test
    public void setCorrectTableNumberTest() { //checks table setting correctly   
        
    }

    @Test
    public void checksIfSettingTableNumberIsNegativeTest() { //checks invalid params 
        
    }

    @Test
    public void correctNumberOfSeatedTest() { //checks seats setting correctly   
        
    }

    @Test
    public void atLeastOneSeatedAndNotTooManySeatedTest() { //checks invalid param  
        
    }

    @Test
    public void tableHasRightTicketTest() { //checks ticket set correctly
        
    }

    @Test
    public void checkForNoTicket() { //checks invalid param with no ticket in it  
        
    }

    @Test
    public void checkForBadTicketVariablesBeforeSettingTicket() { //checks bad ticket param  
        
    }

    @Test
    public void getCorrectTableNumberTest() { //gets correct table#  
        
    }

    @Test
    public void getCorrectNumberOfSeatsTest() { //  gets correct number of seats 
        
    }

    @Test
    public void getCorrectTicketTest1() {   //get ticket
    }

    @Test
    public void checkNoTicketForTable() {   //get error if no ticket  
    }
    
    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("tableTest");
	}

}
